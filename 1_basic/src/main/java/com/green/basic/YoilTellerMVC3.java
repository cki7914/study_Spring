package com.green.basic;


import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC3 {
    @RequestMapping("/getYoilMVC3") //http://localhost:8090/basic/getYoilMVC4?year=2022&month=7&day=aa
    public String main(@ModelAttribute MyDate date, Model model) { 

    	// 1. ��ȿ�� �˻� 
    	if(!isValid(date)) {
    		return "yoilError"; // ���� �̸��� ���� 
    	    
        }
    	
        // 2. ó��
    	//char yoil = getYoil(date); ��ȯŸ�� �տ� @ModelAttribute

    	// 3. model�� ����
    	//model.addAttribute("myDate", date); �Ű����� �տ� @ModelAttribute
      	//model.addAttribute("yoil", yoil);   ��ȯŸ�� �տ� @ModelAttribute     
        
      	// 5. �۾� ����� ������ ���� �̸��� ��ȯ
      	return "yoil";
    }

    private @ModelAttribute("yoil") char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
    }
    
    private boolean isValid(MyDate date) {
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // ������ üũ 
    }
}
