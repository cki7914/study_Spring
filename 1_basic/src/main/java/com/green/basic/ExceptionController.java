package com.green.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	// 예외 처리 메서드
	@ExceptionHandler({NullPointerException.class, ArithmeticException.class})
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main() throws Exception {
		throw new Exception("예외 발생!");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new ArithmeticException("예외 발생!");
	}
}
