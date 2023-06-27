package com.workout.app.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.app.member.dao.MemberDao;
import com.workout.app.member.service.MemberService;
import com.workout.app.member.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Member> selectMemberList() {
		return memberDao.selectMemberList();
	}

	@Override
	public Member selectOneMember(Member member) {
		return memberDao.selectOneMember(member);
	}
}
