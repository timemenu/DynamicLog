package com.dynamiclogs.www.process.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dynamiclogs.www.process.domain.StudyBoard;
import com.dynamiclogs.www.process.repository.StudyBoardRepository;

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
	
	@Autowired
	private StudyBoardRepository studyBoardRepository;
	
	@RequestMapping("/")
	public String main(Model model) {
		List<StudyBoard> studys = (List<StudyBoard>) studyBoardRepository.findTop3ByOrderByRegDateAsc();
		model.addAttribute("studys", studys);
		return "main";
	}
}
