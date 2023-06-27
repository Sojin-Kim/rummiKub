package com.workout.app.game.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.workout.app.game.vo.MainGame;

@Mapper
public interface MainGameDao {

	// 회원 조회
	List<MainGame> selectMainGameList();

	// 로그인 확인
	MainGame selectOneMainGame(MainGame mainGame); 
}
