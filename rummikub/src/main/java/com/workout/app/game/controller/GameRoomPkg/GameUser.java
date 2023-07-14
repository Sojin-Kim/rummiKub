package com.workout.app.game.controller.GameRoomPkg;

import java.net.Socket;

import lombok.Getter;
import lombok.Setter;

/*
 * Author : ksj
 * Desc : 네트워크 게임에서 사용되는(채팅도 포함) 방 개념 클래스
 */

// 실제로 게임을 플레이하는 유저의 클래스이다.
@Getter
@Setter
public class GameUser {

	private int id; 			// Unique ID
	private int roomId; 		// 유저가 속한 룸이다.
	private Socket sock; 		// 소켓 object
	private String nickName;	// 닉네임

	// 게임에 관련된 변수 설정
	// ...
	//

	public GameUser() { // 아무런 정보가 없는 깡통 유저를 만들 때
	}

    /**
     * 유저 생성
     * @param nickName 닉네임
     */
    public GameUser(String nickName) { // 닉네임 정보만 가지고 생성
		this.nickName = nickName;
	}

    /**
     * 유저 생성
     * @param id ID
     * @param nickName 닉네임
     */
    public GameUser(int id, String nickName) { // UID, 닉네임 정보를 가지고 생성
		this.id = id;
		this.nickName = nickName;
	}

    /**
     * 방에 입장시킴
     * @param room  입장할 방
     */
    public void enterRoom(int roomId) {
    	System.out.println("enterRoom > enterUser == "+roomId);
    	
		//room.enterUser(this); // 룸에 입장시킨 후
		this.roomId = roomId; // 유저가 속한 방을 룸으로 변경한다.(중요)
		System.out.println("enterRoom > enterUser == "+roomId);
	}

    /**
     * 방에서 퇴장
     * @param room 퇴장할 방
     */
    @SuppressWarnings("null")
	public void exitRoom(GameRoom room){
        this.roomId = (Integer) null;
        // 퇴장처리(화면에 메세지를 준다는 등)
        // ...
    }

    /*
        equals와 hashCode를 override 해줘야, 동일유저를 비교할 수 있다
        비교할 때 -> gameUser 간 equals 비교, list에서 find 등
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameUser gameUser = (GameUser) o;

        return id == gameUser.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

	@Override
	public String toString() {
		return "GameUser [id=" + id + ", room=, sock=" + sock + ", nickName=" + nickName + "]";
	}
    
    
}
