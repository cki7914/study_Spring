package com.green.basic;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 프로그램 등록
public class YoilTellerMVC {
	@ExceptionHandler
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC") // url 연결
	public ModelAndView main(@RequestParam(required = true) int year,@RequestParam(required = true) int month,@RequestParam(required = true) int day) throws IOException {
		ModelAndView mv = new ModelAndView();
		
//		if(!isValid(year, month, day))
//			return "yoilError"; // /WEB-INF/views/yoilError.jsp
		
	    char yoil = getYoil(year, month, day);
	    
	    mv.addObject("year", year);
	    mv.addObject("month", month);
	    mv.addObject("day", day);
	    mv.addObject("yoil", yoil);
	    
	    // 보여주고싶은 뷰 지정
//	    return "yoil"; // /WEB-INF/views/yoil.jsp
	    mv.setViewName("yoil");
	    return mv;
    }

	private boolean isValid(int year, int month, int day) {
		return false;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, day);
	    
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    return " 일월화수목금토".charAt(dayOfWeek);
	}
} // class
