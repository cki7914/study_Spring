package com.green.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //ȣ�Ⱑ���� ���α׷����� ���
public class hello {
	
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello") //url�� �޼��� ����
	private void main() { //�ν��Ͻ��޼���
		System.out.println("Hello");
		
		System.out.println(cv); //��밡��
		//System.out.println(iv); //��밡��
		
	}
	
	public static void main2() { // ����ƽ�޼���
		System.out.println(cv); //cv ��밡��
		//System.out.println(iv); //iv ������
	}
}




