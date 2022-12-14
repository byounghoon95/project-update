//package com.example.projectupdate.kkh.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.projectupdate.entity.Common;
//import com.example.projectupdate.entity.MemberEntity;
//import com.example.projectupdate.kkh.service.MemberService;
//
//@Slf4j
//@Controller
//public class MemberController {
//	@Autowired
//	private MemberService ms;
//
//	@PostMapping("/idCheck")
//	@ResponseBody
//	public String idcheck(MemberEntity member) {
//		System.out.println("MemberController idCheck start..");
//		String chk = "";
//		int result = 0;
//		if(member.getId().trim() == "") {
//			chk = "none";
//		}else {
//			result = ms.idCheck(member);
//			if(result == 1) {
//				chk = "redundancy";
//			}else if(result == 0) {
//				chk = "noredundancy";
//			}
//		}
//		return chk;
//	}
//
//	@GetMapping("/idFind")
//	public String idFind(Model model) {
//
//		return "memidFind";
//	}
//
//	@GetMapping("/idchk")
//	@ResponseBody
//	public MemberEntity idchk(Model model, MemberEntity member) {
//
//		MemberEntity dbmember = ms.memberSelect(member);
//		return dbmember;
//	}
//
//	@GetMapping("/pwForm")
//	public String pwForm(Model model) {
//
//		return "mempwForm";
//	}
//	@GetMapping("/pwFind")
//	public String pwFind(Model model) {
//
//		return "mempwFind";
//	}
//
//	//로그아웃
//	@GetMapping("/logout")
//	public String memlogout(HttpServletRequest request, MemberEntity member, Model model) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//
//		return "memlogout";
//	}
//
//	//관리자
//	@GetMapping("/adminlogin")
//	public String adminlogin(Model model) {
//
//		return "adminlogin";
//	}
//
//	@PostMapping("/adminloginPro")
//	   public String adminloginPro(HttpServletRequest request, MemberEntity member, Model model) {
//	      System.out.println("adminloginPro start..");
//	      String input_id = member.getId();
//	      String input_pw = member.getPw();
//	      HttpSession session = request.getSession();
//	      session.setAttribute("id", input_id);
//	      System.out.println("input_id -> " + input_id);
//	      System.out.println("input_pw -> " + input_pw);
//	      member = ms.memberLogin(input_id);
////	      member = ms.adminChk(input_id);
//	      session.setAttribute("nickname", member.getNickname());
//	      model.addAttribute("input_id", input_id);
//	      model.addAttribute("input_pw", input_pw);
//	      model.addAttribute("member", member);
//	      return "adminloginPro";
//	   }
//}
