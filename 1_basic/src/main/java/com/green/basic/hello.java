package com.green.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ȣ�� ������ ���α׷����� ���
public class hello {
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello") // URL�� �ż��� ����
	private void main() {
		System.out.println("Hello");
		
		System.out.println(cv);
		System.out.println(iv);
	}
	
	public static void main2() {
		System.out.println(cv); // cv��� ����
//		System.out.println(iv); // iv��� �Ұ�
	}
}
