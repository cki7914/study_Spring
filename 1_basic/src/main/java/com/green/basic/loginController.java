package com.green.basic;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1. id�� pwd�� Ȯ��
		
		if(!loginCheck(id,pwd)) {
			String msg = URLEncoder.encode("id �Ǵ� pw�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			return "redirect:/login/login?msg=" + msg;
		}
		
		//2. id�� pwd�� ��ġ�ϸ� Ȩ���� �̵�
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		if (rememberId) {
			
			//2-1. ��Ű ����
			Cookie cookie = new Cookie("id", id);
			//2-2. ��Ű�� ���信 ����
			response.addCookie(cookie);
			
		} else {
			//2-1. ��Ű ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); //��Ű ����
			//2-2. ��Ű�� ���信 ����
			response.addCookie(cookie);
			
		}
		
		//2-3. Ȩ���� �̵�
		
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:" + toURL;
	}

	private boolean loginCheck(String id, String pwd) {

		return "green".equals(id) && "1234".equals(pwd);
	}
}
