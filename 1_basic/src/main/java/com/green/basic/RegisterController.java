package com.green.basic;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping(value = "/register/add", method = RequestMethod.GET)
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // 회원가입 페이지
//	}
	
//	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws UnsupportedEncodingException {
		// 1. 유효성 검사
		if(isValid(user)) {
			String msg = URLEncoder.encode("id를 확인하세요", "UTF-8");
		}
		// 2. DB에 저장
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
