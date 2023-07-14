package com.workout.app.game.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workout.app.game.controller.GameRoomPkg.GameRoom;
import com.workout.app.game.controller.GameRoomPkg.GameUser;
import com.workout.app.game.service.MainGameService;
import com.workout.app.game.vo.MainGame;

@Controller
@RequestMapping("/game")
public class MainGameController {

	@Autowired
	private MainGameService mainGameService;
	
	// 방 조인하기
	@ResponseBody
	@PostMapping("/createRoom")
	public Map<String, String> createRoom(MainGame mainGame) {
		//방만들기
		GameRoom gameRoom = mainGameService.createRoom(mainGame);
		//model.addAttribute("mainGame",mainGame);
		Map<String, String> result = new HashMap<String, String>();
		result.put("roomId", String.valueOf(gameRoom.getId()));
		//result.put("userList", String.valueOf(gameRoom.getUserList()));
		return result;
	}
	
	// 방 인원수 조회
	@ResponseBody
	@PostMapping("/srchRoom")
	public Map<String, String> srchRoom(MainGame mainGame) {
		//방만들기
		GameRoom gameRoom = mainGameService.srchRoom(mainGame);
		Map<String, String> result = new HashMap<String, String>();
		result.put("gameRoom", gameRoom.toString());
		return result;
	}
	
	// 메인게임 화면 호출
	@GetMapping("/mainGame")
	public String mainGameList(Model model) {
		//GameRoom gameRoom = roomManager.createRoom();
		
		// 사용자
       // GameUser gameUser = new GameUser(1, "gompang");

       // gameRoom.enterUser(gameUser);
        
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
