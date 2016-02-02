package com.dynamiclogs.www.process.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 메인 컨트롤러 클래스입니다.
 *
 * com.dynamiclogs.www.process.main
 * MainController.java
 *
 * @author : quickmenu
 * @date : 2016. 1. 1.
 * @version : 1.0
 *
 */
@Controller
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		return "contents/main";
	}
}
