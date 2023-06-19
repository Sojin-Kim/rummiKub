package com.workout.app.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.workout.app.member.model.dto.Member;

@Mapper
public interface MemberDao {

	// 회원 조회
	List<Member> selectMemberList();

	// 로그인 확인
	Member selectOneMember(Member member); 
}
