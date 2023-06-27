package com.workout.app.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workout.app.game.vo.MainGame;
import com.workout.app.game.service.MainGameService;
/*sample*/
@Controller
@RequestMapping("/game")
public class MainGameController {

	@Autowired
	private MainGameService mainGameService;

	//회원 목록 화면 호출
	@GetMapping("/mainGame")
	public String mainGameList(Model model) {
		//전체 회원 조회
		//List<MainGame> mainGame = mainGameService.selectMainGameList();
		//model.addAttribute("mainGame",mainGame);
		return "game/mainGame";
	}
	
	//로그인 버튼 클릭
	// 세션 추가해야함.(2022.08.17 ksj)
	// id가 admin인 경우 관리자 페이지로 이동.(2022.08.17 ksj)	
	/*@PostMapping("/loginAction.do")
	public String loginAction(MainGame mainGame, RedirectAttributes redirectAttr, Model model) {
		MainGame result = mainGameService.selectOneMainGame(mainGame);	//로그인 확인
		String rdrct = "redirect:/";
		if(result != null) {	// 로그인 성공
			redirectAttr.addFlashAttribute("msg", "로그인 성공!");
			model.addAttribute("mainGame",result);
			if("admin".equals(result.getUserId())) {	// 관리자 페이지
				rdrct += "admin/adminHome.do";
			}
		}else{	// 로그인 실패(회원 없음)
			redirectAttr.addFlashAttribute("msg", "등록되지 않은 아이디입니다.");
		}
		return rdrct;
	}
	*/
}
