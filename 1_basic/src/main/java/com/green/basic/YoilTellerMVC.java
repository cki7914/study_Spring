package com.green.basic;


import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //���α׷� ���
public class YoilTellerMVC {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//�Ű������� ���� �Ѱܹް� ��� ������ �� �Ű������� ������
	@RequestMapping("/getYoilMVC") //url����
    public ModelAndView main(@RequestParam(required=true) int year, 
    						@RequestParam(required=true) int month, 
    						@RequestParam(required=true) int day) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		//�� �Է¿� ���� ��ȿ���˻�
		//if(!isValid(year, month, day)) {
		//	return "yoilError"; //   /WEB-INF/views/yoilError.jsp
		//}
		
		//���� ó�� �޼��� ȣ��
        char yoil = getYoil(year, month, day);
        
        //ó���� ����� model�� ����
        mv.addObject("year",year);
        mv.addObject("month",month);
        mv.addObject("day",day);
        mv.addObject("yoil",yoil);
        
        //
        mv.setViewName("yoil");
        
        return mv;
        
        //�����ְ� ���� �� ����
        //return "yoil";   //   /WEB-INF/views/yoil.jsp
        
    }

	//��ȿ�� �˻縦 ���� �޼���
	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//ó�� ��� �޼���
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}





