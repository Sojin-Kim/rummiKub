package com.workout.app.game.service;

import java.util.List;

import com.workout.app.game.vo.MainGame;

public interface MainGameService {

	// 회원 조회
	List<MainGame> selectMainGameList();

	// 로그인 확인
	MainGame selectOneMainGame(MainGame mainGame);

}
