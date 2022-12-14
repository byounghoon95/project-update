package com.example.projectupdate.user.login.controller;

import com.example.projectupdate.dto.request.RegisterRequest;
import com.example.projectupdate.entity.MemberEntity;
import com.example.projectupdate.user.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Slf4j
@Controller
public class LoginController {

    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/login/login";
    }

    @ResponseBody
    @GetMapping("/user/idCheck")
	public String idCheck(String id) {
		String chk = "";
        String returnStr;

		if(id.trim() == "") {
			chk = "none";
		}else {
            returnStr = loginService.idCheck(id);
            if(returnStr == "memberNotFoundException") {
				chk = "usable";
			}else {
				chk = "nonUsable";
			}
		}
		return chk;
	}

    @GetMapping("/user/register")
    public String registerForm () {
        return "/login/register";
    }

    @PostMapping("/user/register")
    public String register(RegisterRequest request, Model model) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        String role = request.getId().contains("admin") ? "ROLE_ADMIN" : "ROLE_USER";

        request.setRole(role);
        loginService.register(request);
        return "redirect:/login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:loginForm";
    }

    @GetMapping("/")
    public String main() {
        return "login/main";
    }

    @GetMapping("/admin/main")
    public String adminMain(Model model) {
        model.addAttribute("data", "???????????????");
        return "login/admin/main";
    }

    @GetMapping("/admin/login")
    public String adminLogin(@RequestParam(value = "error", required = false) String error,
                             @RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login/admin/login";
    }

//    @PostMapping("/admin/login")
//    public String adminLogin(HttpServletRequest request, MemberEntity member, Model model) {
//        return "login/admin/main";
//    }
}