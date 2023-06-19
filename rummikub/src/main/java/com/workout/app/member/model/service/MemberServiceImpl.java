package com.workout.app.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.app.member.model.dao.MemberDao;
import com.workout.app.member.model.dto.Member;

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
