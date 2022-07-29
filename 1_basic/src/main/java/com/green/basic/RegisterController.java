package com.green.basic;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	//날짜 형식으로 변경하는 메서드
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		
//		binder.setValidator(new UserValidator());
//		binder.addValidators(new UserValidator());
		
		// 등록된 validator 확인하기
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}

	@GetMapping("/add")
	public String register() {
		return "registerForm";
	}
	
	@PostMapping("/add")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{
		System.out.println("user = " + user);
		System.out.println("result = " + result);
		
//		if (!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
// 			m.addAttribute("msg", msg);
//			return "forward:/register/add";
//		}
		
		//���� ���� : Validator�� ���� �����ϰ�, validate()�� ȣ���ؼ� ����
		//UserValidator uservalidator = new UserValidator();
		//uservalidator.validate(user, result);
		
		if (result.hasErrors()) {
			return "registerForm";
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return true;
	}
}
