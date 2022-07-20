package com.green.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 호출 가능한 프로그램으로 등록
public class hello {
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello") // URL과 매서드 연결
	private void main() {
		System.out.println("Hello");
		
		System.out.println(cv);
		System.out.println(iv);
	}
	
	public static void main2() {
		System.out.println(cv); // cv사용 가능
//		System.out.println(iv); // iv사용 불가
	}
}
