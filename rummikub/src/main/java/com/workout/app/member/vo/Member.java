package com.workout.app.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private String userId;		/* 사용자ID */
	private String email;		/* 이메일 */
	private String password;    /* 비밀번호 */
	private String name;        /* 사용자이름 */
	private String phoneNum;    /* 핸드폰번호 */
	private String createdDate; /* 등록일자 */
}
