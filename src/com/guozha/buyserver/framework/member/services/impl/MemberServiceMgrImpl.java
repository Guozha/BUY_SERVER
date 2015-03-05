/**
 * 
 */
package com.guozha.buyserver.framework.member.services.impl;

import java.util.List;

import com.guozha.buyserver.framework.exception.ObjectDuplicateException;
import com.guozha.buyserver.framework.exception.ObjectHasSubObjectException;
import com.guozha.buyserver.framework.member.Member;
import com.guozha.buyserver.framework.member.persistence.UsrMemberMapper;
import com.guozha.buyserver.framework.member.services.MemberServiceMgr;
import com.guozha.buyserver.framework.member.services.object.ConditionVO;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author peng.shi
 *
 */
public class MemberServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements MemberServiceMgr
{
	private UsrMemberMapper usrMemberMapper;
	
	public UsrMemberMapper getUsrMemberMapper()
	{
		return usrMemberMapper;
	}

	public void setUsrMemberMapper(UsrMemberMapper usrMemberMapper)
	{
		this.usrMemberMapper = usrMemberMapper;
	}
	
	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#addMember(com.guozha.buyserver.framework.member.Member)
	 */
	@Override
	public Member addMember(Member member) throws ObjectDuplicateException
	{
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#confiredMember(com.guozha.buyserver.framework.member.Member)
	 */
	@Override
	public Member confiredMember(Member member)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#createMember(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Member createMember(String email, String username, String password)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#deleteMember(com.guozha.buyserver.framework.member.Member)
	 */
	@Override
	public Member deleteMember(Member member)
			throws ObjectHasSubObjectException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#getMember(java.lang.Long)
	 */
	@Override
	public Member getMember(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#getMemberByEmail(java.lang.String)
	 */
	@Override
	public Member getMemberByEmail(String email)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#getMemberByUsername(java.lang.String)
	 */
	@Override
	public Member getMemberByUsername(String username)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#getMembers(com.guozha.buyserver.framework.member.services.object.ConditionVO, int, int)
	 */
	@Override
	public List<Member> getMembers(ConditionVO vo, int offset, int limit)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#getTotalMembers(com.guozha.buyserver.framework.member.services.object.ConditionVO)
	 */
	@Override
	public int getTotalMembers(ConditionVO vo)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.guozha.buyserver.framework.member.services.MemberSrvMgr#updateMember(com.guozha.buyserver.framework.member.Member)
	 */
	@Override
	public Member updateMember(Member member)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
