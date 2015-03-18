package com.guozha.buyserver.service.account.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.DateUtil;
import com.guozha.buyserver.common.util.ParameterUtil;
import com.guozha.buyserver.common.util.SmsUtil;
import com.guozha.buyserver.common.util.SystemResource;
import com.guozha.buyserver.framework.enums.ReturnCodeEnum;
import com.guozha.buyserver.framework.enums.TicketRewardEnum;
import com.guozha.buyserver.framework.enums.TicketTypeEnum;
import com.guozha.buyserver.framework.enums.YesNo;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccMyInvite;
import com.guozha.buyserver.persistence.beans.AccMyTicket;
import com.guozha.buyserver.persistence.beans.SysSeq;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.AccountMapper;
import com.guozha.buyserver.persistence.mapper.SysUserMapper;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AccountInfoResponse;
import com.guozha.buyserver.web.controller.account.BalanceResponse;
import com.guozha.buyserver.web.controller.account.GenerateInviteResponse;
import com.guozha.buyserver.web.controller.account.InviteResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.PasswdRequest;
import com.guozha.buyserver.web.controller.account.PasswdResponse;
import com.guozha.buyserver.web.controller.account.RegisterRequest;
import com.guozha.buyserver.web.controller.account.TicketRequest;

@Transactional(rollbackFor = Exception.class)
@Service("accountService")
public class AccountServiceImpl extends AbstractBusinessObjectServiceMgr implements AccountService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public MsgResponse getCheckCodeForReg(String mobileNo) {

		Object[] arr = new Object[1];
		arr[0] = RandomStringUtils.randomNumeric(6);
		SmsUtil.sendSms("01", mobileNo, arr);// SMS_TYPE 01-注册获取验证码

		return new MsgResponse();
	}

	@Override
	public MsgResponse register(RegisterRequest vo) {

		String checkCode = SmsUtil.getCheckCode(vo.getMobileNo());// 获取服务端缓存的验证码
		if (!(vo.getCheckCode().equals(checkCode))) {
			return new MsgResponse("0", "验证码错误");
		}

		SysUser po = sysUserMapper.getUserByMobileNo(vo.getMobileNo());
		if (po == null) {

			po = new SysUser();
			po.setMobileNo(vo.getMobileNo());
			po.setPasswd(vo.getPasswd());
			po.setRegTime(new Date());
			po.setStatus("1");// USER_STATUS 1-可用
			sysUserMapper.insert(po);

			SmsUtil.removeCheckCode(vo.getMobileNo());

			return new MsgResponse("1", "注册成功");
		} else {
			return new MsgResponse("0", "该手机已注册过了");
		}

	}

	@Override
	public LoginResponse login(LoginRequest vo) {

		LoginResponse bo = new LoginResponse();

		SysUser po = sysUserMapper.getLoginUser(vo);
		if (po == null) {
			bo.setReturnCode("0");
			bo.setMsg("用户名或密码错误");
		} else {
			if ("3".equals(po.getStatus())) {// USER_STATUS 3-停用
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("0");
				bo.setMsg("该账户已被停用");
			} else {
				String token = RandomStringUtils.randomAlphanumeric(32);

				bo.setToken(token);
				bo.setUserId(po.getUserId());
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("1");
				bo.setMsg("登录成功");

			}

		}

		return bo;
	}

	@Override
	public MsgResponse logout(String token) {
		ParameterUtil.removeToken(token);
		return new MsgResponse();
	}

	/**
	 * 获取账户余额
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 */
	public BalanceResponse balance(SysUser user) {
		BalanceResponse response = null;
		if (user != null && user.getUserId() > 0) {
			response = accountMapper.getMyBalance(user.getUserId());
		}
		return response;
	}

	/**
	 * 获取账户信息
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 */
	public AccountInfoResponse info(SysUser user) {
		AccountInfoResponse response = null;
		if (user != null && user.getUserId() > 0) {
			response = accountMapper.getMyAccountInfo(user.getUserId());
		}
		return response;
	}

	/**
	 * 修改密码
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 */
	public PasswdResponse updatePasswd(PasswdRequest request) {
		PasswdResponse response = new PasswdResponse();
		int count = 0;
		if (request != null) {
			if (StringUtils.isNotEmpty(request.getPasswd())) {
				String checkCode = SmsUtil.getCheckCode(request.getMobileNo());// 获取服务端缓存的验证码
				String in_checkcode = request.getCheckCode();
				if (StringUtils.isEmpty(in_checkcode)) {
					response.setReturnCode(ReturnCodeEnum.FAILED.status);
					response.setMsg("验证码为空");
					return response;
				} else if (!(in_checkcode.equals(checkCode))) {
					response.setReturnCode(ReturnCodeEnum.FAILED.status);
					response.setMsg("验证码错误");
					return response;
				}
				if (StringUtils.isEmpty(request.getPasswd())) {
					response.setReturnCode(ReturnCodeEnum.FAILED.status);
					response.setMsg("密码为空");
					return response;
				}
				count = accountMapper.updatePasswd(request);
			}
		}
		if (count == 1) {
			response.setReturnCode(ReturnCodeEnum.SUCCESS.status);
			response.setMsg("密码修改成功");
		} else {
			response.setReturnCode(ReturnCodeEnum.FAILED.status);
			response.setMsg("密码修改失败");
		}
		return response;
	}

	/**
	 * 汇总邀请信息
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 */
	public InviteResponse listInvite(SysUser user) {
		InviteResponse response = null;
		if (user != null) {
			int userId = user.getUserId();
			if (userId > 0) {
				int drawCount = accountMapper.countDrawTicket(userId);
				int usedCount = accountMapper.countUsedTicket(userId);
				int money = drawCount * TicketRewardEnum.drawReward.getReward() + drawCount * TicketRewardEnum.usedReward.getReward();
				response = new InviteResponse();
				response.setDrawAmount(drawCount);
				response.setUsedAmount(usedCount);
				response.setAwardPrice(money);
			}
		}
		return response;
	}

	/**
	 * 生成邀请
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 */
	public GenerateInviteResponse invite(SysUser user) {
		GenerateInviteResponse inviteResponse = new GenerateInviteResponse();
		inviteResponse.setReturnCode(ReturnCodeEnum.FAILED.status);
		if (user != null) {
			int userId = user.getUserId();
			if (userId > 0) {
				AccMyInvite invite = new AccMyInvite();
				invite.setUserId(userId);
				invite.setTicketNo(generateTicketNo(TicketTypeEnum.share.getCode()));// 推广获得菜票
				invite.setParValue(Integer.parseInt(SystemResource.getConfig(TicketTypeEnum.share.getType())));
				invite.setInviteTime(Timestamp.valueOf(DateUtil.date2String(new Date(), DateUtil.PATTERN_STANDARD)));
				invite.setUseFlag(String.valueOf(YesNo.No.getCode()));
				invite.setDrawFlag(String.valueOf(YesNo.No.getCode()));
				accountMapper.insertInvite(invite);
				int inviteId = invite.getMyInviteId();
				if (inviteId > 0) {
					inviteResponse.setInviteId(inviteId);
					inviteResponse.setReturnCode(ReturnCodeEnum.SUCCESS.status);
					inviteResponse.setMsg("生成邀请成功");
				}
			}
		}
		return inviteResponse;
	}

	/**
	 * 菜票编号生成规则
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 */
	public String generateTicketNo(String ticketType) {
		int maxLen = 8;
		String current_no = accountMapper.getCurrentNo(ticketType);
		SysSeq seq = new SysSeq();
		seq.setSeqType(ticketType);
		String seqNo = "", temp = "", final_no = "";
		if (StringUtils.isEmpty(current_no) || Integer.parseInt(current_no) <= 0) {
			// 不存在則新增数据
			seqNo = StringUtils.leftPad(String.valueOf("1"), 8, "0");
			seq.setSeqNo(seqNo);
			int seqId = accountMapper.insertSeqNo(seq);
			if (seqId > 0) {
				temp = StringUtils.leftPad(seqNo, 22, DateUtil.date2String(new Date(), "yyyyMMddHHmmss"));
				final_no = ticketType + "00" + temp;
			}
		} else {
			int nextSeqNo = Integer.parseInt(current_no) + 1;
			if (String.valueOf(nextSeqNo).length() > maxLen) {
				throw new RuntimeException("编号长度超限");
			}
			// 更新记录
			String s_nextSeqNo = StringUtils.leftPad(String.valueOf(nextSeqNo), 8, "0");
			seq.setSeqNo(String.valueOf(s_nextSeqNo));
			int count = accountMapper.updateSeqNo(seq);
			if (count == 1) {
				temp = StringUtils.leftPad(s_nextSeqNo, 22, DateUtil.date2String(new Date(), "yyyyMMddHHmmss"));
				final_no = ticketType + "00" + temp;
			}
		}
		// System.out.println("final_no==========" + final_no);
		return final_no;
	}

	/**
	 * 我的菜票查询
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public List<AccMyTicket> list(TicketRequest ticket) {
		List<AccMyTicket> response = null;
		if (ticket != null) {
			int userId = ticket.getUserId();
			if (userId > 0) {
				// 1.查询所有有效菜票
				response = accountMapper.listTicketValid(userId);
				// 2、查询一个月内失效菜票
				List<AccMyTicket> list_response = accountMapper.listTicketInvalid(userId);
				for (int i = 0; i < list_response.size(); i++) {
					response.add(list_response.get(i));
				}
			}
		}
		return response;
	}

	/**
	 * 找回密码获取验证码
	 * 
	 * @param mobileNo
	 * @return
	 */
	public MsgResponse checkCodeForResetPasswd(String mobileNo) {
		Object[] arr = new Object[1];
		arr[0] = RandomStringUtils.randomNumeric(6);
		SmsUtil.sendSms("02", mobileNo, arr);// SMS_TYPE 02-找回密码获取验证码
		return new MsgResponse();
	}

}
