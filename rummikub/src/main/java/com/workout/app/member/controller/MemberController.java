package com.workout.app.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workout.app.member.model.dto.Member;
import com.workout.app.member.model.service.MemberService;
/*sample*/
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	//회원 목록 화면 호출
	@GetMapping("/memberList.do")
	public String memberList(Model model) {
		//전체 회원 조회
		List<Member> member = memberService.selectMemberList();
		model.addAttribute("member",member);
		return "member/memberList";
	}
	
	//로그인 화면 호출
	@GetMapping("/loginForm.do")
	public String loginForm(Model model) {
		return "member/loginForm";
	}
	
	//로그인 버튼 클릭
	// 세션 추가해야함.(2022.08.17 ksj)
	// id가 admin인 경우 관리자 페이지로 이동.(2022.08.17 ksj)	
	@PostMapping("/loginAction.do")
	public String loginAction(Member member, RedirectAttributes redirectAttr, Model model) {
		Member result = memberService.selectOneMember(member);	//로그인 확인
		String rdrct = "redirect:/";
		if(result != null) {	// 로그인 성공
			redirectAttr.addFlashAttribute("msg", "로그인 성공!");
			model.addAttribute("member",result);
			if("admin".equals(result.getUserId())) {	// 관리자 페이지
				rdrct += "admin/adminHome.do";
			}
		}else{	// 로그인 실패(회원 없음)
			redirectAttr.addFlashAttribute("msg", "등록되지 않은 아이디입니다.");
		}
		return rdrct;
	}
	
}
