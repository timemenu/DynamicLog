package com.dynamiclogs.www.process.user.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/signin")
public class SigninController {

	// 로그인
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signin(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contents/signin");
		return mv;
	}
}
