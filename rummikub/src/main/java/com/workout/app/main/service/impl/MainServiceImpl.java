package com.workout.app.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.app.main.dao.MainDao;
import com.workout.app.main.service.MainService;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	private MainDao mainDao;

}
