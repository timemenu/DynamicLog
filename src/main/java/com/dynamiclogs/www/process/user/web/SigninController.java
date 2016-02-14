package com.dynamiclogs.www.process.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signin")
public class SigninController {

	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model) {
		return "contents/signin";
	}
}