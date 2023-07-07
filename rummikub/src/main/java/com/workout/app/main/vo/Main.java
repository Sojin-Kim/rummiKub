package com.workout.app.main.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main {
	
	private String userId;		/* 사용자ID */
	private String email;		/* 이메일 */
	private String password;    /* 비밀번호 */
	private String name;        /* 사용자이름 */
}
