package com.green.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //호출가능한 프로그램으로 등록
public class hello {
	
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello") //url과 메서드 연결
	private void main() { //인스턴스메서드
		System.out.println("Hello");
		
		System.out.println(cv); //사용가능
		//System.out.println(iv); //사용가능
		
	}
	
	public static void main2() { // 스테틱메서드
		System.out.println(cv); //cv 사용가능
		//System.out.println(iv); //iv 사용못함
	}
}




