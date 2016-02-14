package com.dynamiclogs.www.process.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	// 회원가입
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contents/signup");
		return mv;
	}
}
