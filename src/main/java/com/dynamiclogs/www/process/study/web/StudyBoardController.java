package com.dynamiclogs.www.process.study.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dynamiclogs.www.process.study.domain.StudyBoard;
import com.dynamiclogs.www.process.study.repository.StudyBoardRepository;

@Controller
@RequestMapping(value="/study")
public class StudyBoardController {
	
	@Autowired 
	private StudyBoardRepository studyBoardRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String study(Model model) {
		List<StudyBoard> studys = (List<StudyBoard>) studyBoardRepository.findAllByOrderByRegDateAsc();
		model.addAttribute("studys", studys);
		return "contents/study";
	}
	
	@RequestMapping(headers="Content-Type=application/json", value="/save", method=RequestMethod.POST)
	public @ResponseBody StudyBoard saveStudyContent(@RequestBody StudyBoard studyBoard) {
		studyBoardRepository.save(studyBoard);
		return studyBoard;
	}
	
}
