package com.green.basic;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	// 날짜 형식으로 변경하는 메서드
	@InitBinder
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		// registerCustomEditor : 데이터의 타입을 변환하기 위해 스프링에서 기본 제공하는 매서드
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		
		// String 배열 형태의 글자를 받아와서 구분자(#)을 기준으로 잘라줌
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
	//@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/add")
	public String register() {
		return "registerForm";
	}
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/add")
	public String save(User user, BindingResult result, Model m) throws Exception{
		System.out.println("user = " + user);
		System.out.println("result = " + result);
		//1. 
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하였습니다.", "utf-8");
 			m.addAttribute("msg", msg);
			return "forward:/register/add";
		}
		//2. 
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return true;
	}
}
