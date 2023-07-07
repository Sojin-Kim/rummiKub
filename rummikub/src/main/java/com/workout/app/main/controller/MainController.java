package com.workout.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workout.app.main.service.MainService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService mainService;

	//메인 화면 호출
	@GetMapping("/main")
	public String memberList(Model model) {
		return "main/main";
	}
	
}
