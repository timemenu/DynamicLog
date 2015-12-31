package com.dynamiclogs.www.process.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dynamiclogs.www.process.domain.StudyBoard;
import com.dynamiclogs.www.process.repository.StudyBoardRepository;

@Controller
public class MainController {
	
	@Autowired
	private StudyBoardRepository studyBoardRepository;
	
	@RequestMapping("/")
	public String main(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		
		List<StudyBoard> studys = (List<StudyBoard>) studyBoardRepository.findAll();
		for(StudyBoard sb : studys) {
			System.out.println(sb.getContent());
		}
				
		model.addAttribute("studys", studys);
		return "main";
	}
}
