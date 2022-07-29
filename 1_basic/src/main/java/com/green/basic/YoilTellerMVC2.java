package com.green.basic;


import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���α׷� ���
public class YoilTellerMVC2 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//�Ű������� ���� �Ѱܹް� ��� ������ �� �Ű������� ������
	@RequestMapping("/getYoilMVC2") //url����
    public String main(MyDate date, Model model) throws IOException {
		
		//�� �Է¿� ���� ��ȿ���˻�
		if(!isValid(date)) {
			return "yoilError";
		}
		
		//���� ó�� �޼��� ȣ��
        char yoil = getYoil(date);
        
        //ó���� ����� model�� ����
        model.addAttribute("myDate", date);
        model.addAttribute("yoil",yoil);
        
        return "yoil";
        
        
    }

	private char getYoil(MyDate date) {
		// TODO Auto-generated method stub
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	//��ȿ�� �˻縦 ���� �޼���
	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	} 
	
	
	private boolean isValid(int year, int month, int day) {    
    	return true;
    }

	//ó�� ��� �޼���
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}





