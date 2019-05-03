package com.Myapp.test.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Myapp.test.util.userutil.*;

/**
 * 1. className : UserController.java 
 * 2. Comment   : 회원가입, 로그인 및 로그아웃 관련 Controller 
 * 3. 작성일             : 2019.04.09
 */

@Controller 
@RequestMapping("/main/user/*")
public class UserController extends ExamTest {
	
	int Calcresult = 0; 
	
	@RequestMapping
	public String mainPage(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		
		Calcresult = Calc(1, 2);
		
		
		System.out.println("Calcresult = " + Calcresult);
		return "/main/user/main";
	}	

}
