package com.workout.app.game.service;

import com.workout.app.game.controller.GameRoomPkg.GameRoom;
import com.workout.app.game.controller.GameRoomPkg.GameUser;
import com.workout.app.game.vo.MainGame;

public interface MainGameService {

	// 방만들기
	GameRoom createRoom(MainGame mainGame);

	// 접속한 방 조회
	GameRoom srchRoom(MainGame mainGame);

}
