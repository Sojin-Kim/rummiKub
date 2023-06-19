package com.workout.app.member.model.service;

import java.util.List;

import com.workout.app.member.model.dto.Member;

public interface MemberService {

	// 회원 조회
	List<Member> selectMemberList();

	// 로그인 확인
	Member selectOneMember(Member member);

}
