package com.guozha.buyserver.service.account.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.guozha.buyserver.persistence.beans.AccMyTicketCount;
import com.guozha.buyserver.persistence.beans.SysSeq;
import com.guozha.buyserver.persistence.beans.SysSmsSend;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.AccountMapper;
import com.guozha.buyserver.persistence.mapper.SysUserMapper;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AcceptRequest;
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
	@Autowired
	private CommonService commonService;

	@Override
	public MsgResponse getCheckCodeForReg(String mobileNo) {
		if (StringUtils.isBlank(mobileNo)) {
			return new MsgResponse("0", "手机号码未传递");
		}
		Object[] arr = new Object[1];
		arr[0] = RandomStringUtils.randomNumeric(6);
		System.out.println("%%%%%%%%%%%%%%%注册校验码%%%%%%%%%%%%-----" + arr[0]);
		SmsUtil.sendSms("01", mobileNo, arr);// SMS_TYPE 01-注册获取验证码
		SysSmsSend sms = new SysSmsSend();
		sms.setMobileNo(mobileNo);
		sms.setSendStatus(YesNo.Yes.getCode().toString());
		sms.setSendTime(DateUtil.currentTimestamp());
		sms.setSendType("注册获取验证码");
		sms.setSendText(String.format(SystemResource.getConfig("sms.content.register"), arr));
		commonService.insertSms(sms);
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
		SysSmsSend sms = new SysSmsSend();
		sms.setMobileNo(mobileNo);
		sms.setSendStatus(YesNo.Yes.getCode().toString());
		sms.setSendTime(DateUtil.currentTimestamp());
		sms.setSendType("找回密码获取验证码");
		sms.setSendText(String.format(SystemResource.getConfig("sms.content.resetPasswd"), arr));
		commonService.insertSms(sms);
		return new MsgResponse();
	}

	/**
	 * 菜票领用
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public MsgResponse accept(AcceptRequest accept) {
		MsgResponse response = new MsgResponse();
		if (accept != null) {
			AccMyInvite myInvite = accountMapper.listMyInvite(accept.getInviteId());// 邀请信息对象
			SysUser acceptor = sysUserMapper.getUserByMobileNo(accept.getMobileNo());// 领用人user对象
			if (myInvite == null) {
				response.setReturnCode(YesNo.No.getCode().toString());
				response.setMsg("邀请信息不存在");
				return response;
			}
			if (acceptor == null) {
				response.setReturnCode(YesNo.No.getCode().toString());
				response.setMsg("用户未注册");
				return response;
			}
			int send_userId = myInvite.getUserId();// 发放人
			int get_userId = acceptor.getUserId();// 接收人
			if (send_userId == get_userId) {
				response.setReturnCode(YesNo.No.getCode().toString());
				response.setMsg("对不起，不能领取自己发放的菜票");
				return response;
			}
			// 1、检查是否已领用过该用户的菜票
			accept.setTicketNo(myInvite.getTicketNo());
			accept.setUserId(send_userId);
			accept.setGetUserId(get_userId);
			Integer count = accountMapper.checkAccept(accept);
			if (count != null && count.intValue() == 1) {// 已领用
				response.setReturnCode(YesNo.No.getCode().toString());
				response.setMsg("对不起，来自同一发放人的邀请菜票只能领取一次");
				return response;
			}
			// 2、一周只能领取一张菜票
			count = accountMapper.checkWeekAccept(accept);
			if (count != null && count.intValue() == 1) {
				response.setReturnCode(YesNo.No.getCode().toString());
				response.setMsg("对不起，您本周已领用过菜票，无法再次领用");
				return response;
			}
			// 3、邀请受益：
			// ①领取人受益：生成一张面值5元的菜票
			AccMyTicket ticket = new AccMyTicket();
			ticket.setUserId(get_userId);
			ticket.setTicketType(TicketTypeEnum.register.getCode());// 分享受益
			ticket.setParValue(Integer.parseInt(SystemResource.getConfig(TicketTypeEnum.share.getType())));// 面值
			ticket.setForPrice(Integer.parseInt(SystemResource.getConfig("ticket.for_price")));// 满多少金额可用
			ticket.setStatus(YesNo.Yes.getCode().toString());
			ticket.setTicketNo(myInvite.getTicketNo());
			int myTicketId = insertTicket(ticket);
			if (myTicketId > 0) {
				// 更新菜票邀请表
				AccMyInvite invite = new AccMyInvite();
				invite.setDrawFlag(YesNo.Yes.getCode().toString());
				invite.setTicketNo(accept.getTicketNo());
				invite.setToMobileNo(accept.getMobileNo());
				count = accountMapper.updateInvite(invite);
				if (count.intValue() != 1) {
					response.setReturnCode(YesNo.No.getCode().toString());
					response.setMsg("更新邀请表失败");
					return response;
				}
				// 受益人发放菜票放入统计表
				AccMyTicketCount ticketCount = new AccMyTicketCount();
				ticketCount.setUserId(send_userId);
				ticketCount.setTicketDrawCount(1);// 一张
				insertTicketCount(ticketCount);
				// ②发放人受益：领取人达到5人后才可返赠一张菜票
				count = accountMapper.getTicketDrawCount(send_userId);
				if (count != null && count.intValue() == Integer.parseInt(SystemResource.getConfig("ticket.draw.user.count"))) {
					Map map = new HashMap<String, Object>();
					map.put("userId", send_userId);
					map.put("ticketNo", generateTicketNo(TicketTypeEnum.share.getCode()));
					accountMapper.resetTicketCount(map);
				}
			}
		}
		return response;
	}

	/**
	 * 生成菜票：插入菜票表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-25
	 * @param ticket
	 * @return
	 */
	public int insertTicket(AccMyTicket ticket) {
		if (ticket != null)
			accountMapper.insertTicket(ticket);
		return ticket.getMyTicketId();
	}

	/**
	 * 插入发放人菜票统计表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-25
	 * @param ticketCount
	 * @return
	 */
	public int insertTicketCount(AccMyTicketCount ticketCount) {
		if (ticketCount != null)
			accountMapper.insertTicketCount(ticketCount);
		return ticketCount.getUserId();
	}

	@Override
	public SysUser getUserByMobileNo(String mobileNo) {
		return sysUserMapper.getUserByMobileNo(mobileNo);
	}

	public void setSysUserMapper(SysUserMapper sysUserMapper) {
		this.sysUserMapper = sysUserMapper;
	}

	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * 头像设置
	 * 
	 * @author sunhanbin
	 * @date 2015-03-25
	 * @param user
	 * @return
	 */
	public MsgResponse setHeadImg(SysUser user) {
		MsgResponse response = new MsgResponse();
		if (user != null) {
			int count = accountMapper.setHeadImg(user);
			if (count != 1) {
				response.setReturnCode(YesNo.No.getCode().toString());
				response.setMsg("操作失败");
			}
		}
		return response;
	}

	public SysUserMapper getSysUserMapper() {
		return sysUserMapper;
	}

	@Override
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	@Override
	public CommonService getCommonService() {
		return commonService;
	}

}
