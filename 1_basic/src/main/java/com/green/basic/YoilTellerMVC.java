package com.green.basic;


import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //프로그램 등록
public class YoilTellerMVC {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//매개변수로 값을 넘겨받고 뷰로 전달할 모델 매개변수로 선언함
	@RequestMapping("/getYoilMVC") //url연결
    public ModelAndView main(@RequestParam(required=true) int year, 
    						@RequestParam(required=true) int month, 
    						@RequestParam(required=true) int day) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		//값 입력에 대한 유효성검사
		//if(!isValid(year, month, day)) {
		//	return "yoilError"; //   /WEB-INF/views/yoilError.jsp
		//}
		
		//실제 처리 메서드 호출
        char yoil = getYoil(year, month, day);
        
        //처리한 결과를 model로 저장
        mv.addObject("year",year);
        mv.addObject("month",month);
        mv.addObject("day",day);
        mv.addObject("yoil",yoil);
        
        //
        mv.setViewName("yoil");
        
        return mv;
        
        //보여주고 싶은 뷰 지정
        //return "yoil";   //   /WEB-INF/views/yoil.jsp
        
    }

	//유효성 검사를 위한 메서드
	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//처리 담당 메서드
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
	}
}





