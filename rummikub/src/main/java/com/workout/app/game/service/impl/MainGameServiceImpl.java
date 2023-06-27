package com.workout.app.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.app.game.dao.MainGameDao;
import com.workout.app.game.service.MainGameService;
import com.workout.app.game.vo.MainGame;

@Service
public class MainGameServiceImpl implements MainGameService{

	@Autowired
	private MainGameDao mainGameDao;
	
	@Override
	public List<MainGame> selectMainGameList() {
		return mainGameDao.selectMainGameList();
	}

	@Override
	public MainGame selectOneMainGame(MainGame mainGame) {
		return mainGameDao.selectOneMainGame(mainGame);
	}
}
