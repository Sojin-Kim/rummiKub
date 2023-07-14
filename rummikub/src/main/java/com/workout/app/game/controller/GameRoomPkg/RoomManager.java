package com.workout.app.game.controller.GameRoomPkg;

/*
 * Author : ksj
 * Desc : 네트워크 게임에서 사용되는(채팅도 포함) 방 개념 클래스
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.workout.app.game.vo.MainGame;

public class RoomManager {

    private static List<GameRoom> roomList; // 방의 리스트
    private static AtomicInteger atomicInteger;

    public List<GameRoom> getRoomList() {
		return roomList;
	}

	static {
        roomList = new ArrayList<GameRoom>();
        atomicInteger = new AtomicInteger();
    }

    public RoomManager() {

    }

    /**
     * 빈 룸을 생성
     * @return GameRoom
     */
    public GameRoom createRoom(MainGame mainGame) { // 룸을 새로 생성(빈 방)
        int roomId = atomicInteger.incrementAndGet();// room id 채번
        GameRoom room = new GameRoom(roomId);
        room.setGamerCnt(mainGame.getGamerCnt());
        room.setGameAmt(mainGame.getGameAmt());
        room.setTurnTime(mainGame.getTurnTime());
        roomList.add(room);
        System.out.println("Room Created!");
        return room;
    }

    /**
     * 방을 생성함과 동시에 방장을 만들어줌
     * @param owner 방장
     * @return GameRoom
     */
  /*  public static GameRoom createRoom(GameUser owner) { // 유저가 방을 생성할 때 사용(유저가 방장으로 들어감)
        int roomId = atomicInteger.incrementAndGet();// room id 채번

        GameRoom room = new GameRoom(roomId);
        room.enterUser(owner);
        room.setOwner(owner);

        roomList.add(room);
        System.out.println("Room Created!");
        return room;
    }
*/
    public static GameRoom getRoom(GameRoom gameRoom){

        int idx = roomList.indexOf(gameRoom);

        if(idx > 0){
            return (GameRoom) roomList.get(idx);
        }
        else{
            return null;
        }
    }

    public static GameRoom getRoom(int roomId){
    	GameRoom rRoom = null;
	    for(GameRoom room : roomList) {
			System.out.println("RoomManager room----==="+room);
			System.out.println("RoomManager room.getId()----==="+room.getId());
			System.out.println("RoomManager roomId----==="+roomId);
	    	if(room.getId() == roomId) {
	    		rRoom = room;
	    	}
	    }

		System.out.println("RoomManager rRoom----==="+rRoom);
        return rRoom;
    }
    /**
     * 전달받은 룸을 제거
     * @param room 제거할 룸
     */
    public static void removeRoom(GameRoom room) {
        room.close();
        roomList.remove(room); // 전달받은 룸을 제거한다.
        System.out.println("Room Deleted!");
    }

    /**
     * 방의 현재 크기를 리턴
     * @return 현재 size
     */
    public int roomCount() {
        return roomList.size();
    }
}