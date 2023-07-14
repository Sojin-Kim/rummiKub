package com.workout.app.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.app.game.controller.GameRoomPkg.GameRoom;
import com.workout.app.game.controller.GameRoomPkg.GameUser;
import com.workout.app.game.controller.GameRoomPkg.RoomManager;
import com.workout.app.game.dao.MainGameDao;
import com.workout.app.game.service.MainGameService;
import com.workout.app.game.vo.MainGame;

@Service
public class MainGameServiceImpl implements MainGameService{

	@Autowired
	private MainGameDao mainGameDao;

	// 방 총괄 관리
	RoomManager roomManager = new RoomManager();

	@Override
	public GameRoom createRoom(MainGame mainGame) {

		// 사용자(임시) -> 화면에서 받아오기
        GameUser gameUser = new GameUser(mainGame.getMid(), mainGame.getNickName());
        GameRoom resultRoom = null;
		System.out.println("mainGame----==="+mainGame);
		System.out.println("roomManager----==="+roomManager.roomCount());
		System.out.println("roomManager----==="+roomManager.getRoomList());
		// 생성된 방 확인
		if(roomManager.roomCount() == 0) {
			// 새로운 방 생성해서 사용자 넣기
			GameRoom gameRoom = roomManager.createRoom(mainGame);	// 새로운 방 생성
			// 사용자 방에 넣기
			gameUser.setRoomId(gameRoom.getId());
	        gameRoom.enterUser(gameUser);
	        resultRoom = gameRoom;
		}else {
			int roomId = 0;
			for(GameRoom cRoom : roomManager.getRoomList()) {
				// 선택한 참가자수 확인, 차있는지 확인 -> 방이 있다면 그 방id 가져와서 사용자 넣기
				//                            -> 방없다면 새로운 방 생성해서 사용자 넣기
				if(cRoom.getGamerCnt() == mainGame.getGamerCnt() &&
					cRoom.getGameAmt() == mainGame.getGameAmt() &&
					cRoom.getTurnTime() == mainGame.getTurnTime() &&
					cRoom.getGamerCnt() > (cRoom.getUserSize())) {	// 선택한 참가자수/턴/입장료 확인, 차있는지 확인
					// 사용자 방에 넣기
					roomId = cRoom.getId();
					gameUser.setRoomId(cRoom.getId());
					cRoom.enterUser(gameUser);
					resultRoom = cRoom;
					break;
				}
			}
			if(roomId == 0) {
				// 새로운 방 생성해서 사용자 넣기
				GameRoom gameRoom = roomManager.createRoom(mainGame);	// 새로운 방 생성
				// 사용자 방에 넣기
				gameUser.setRoomId(gameRoom.getId());
		        gameRoom.enterUser(gameUser);
		        resultRoom = gameRoom;
			}
		}
		
		System.out.println("roomManager----==="+gameUser);
		System.out.println("roomManager----==="+roomManager.getRoomList());

		return resultRoom;
	}

	@Override
	public GameRoom srchRoom(MainGame mainGame) {
		System.out.println("mainGame----==="+mainGame);
		System.out.println("mainGame----==="+mainGame.getRoomId());
		GameRoom room = roomManager.getRoom(mainGame.getRoomId());

		System.out.println("room----==="+room);
		return room;
	}
	
}
