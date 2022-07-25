package com.green.basic;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 프로그램 등록
public class YoilTellerMVC2 {
	@ExceptionHandler
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2") // url 연결
	public String main(MyDate date, Model model) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		if(!isValid(date)) {
			return "yoilError";
		}
			
	    char yoil = getYoil(date);
	    
	    model.addAttribute("myDate", date);
	    model.addAttribute("yoil", yoil);
	    
	    // 보여주고싶은 뷰 지정
//	    return "yoil"; // /WEB-INF/views/yoil.jsp
	    mv.setViewName("yoil");
	    return "yoil";
    }

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}
	
	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(MyDate date) {
		Calendar cal = Calendar.getInstance();
	    cal.set(date.getYear(), date.getMonth() - 1, date.getDay());
	    
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    return " 일월화수목금토".charAt(dayOfWeek);
	}
} // class
