package com.workout.app.game.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainGame {
	
	private int mid;		/* 사용자ID */
	private String nickName;        /* 사용자이름 */
	
	private int turnTime; /* 턴타임 */
	private int gamerCnt; /* 참가자수 */
	private int gameAmt;  /* 입장료 */

	private int roomId;  /* 방ID */
}
