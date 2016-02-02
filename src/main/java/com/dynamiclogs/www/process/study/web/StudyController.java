package com.dynamiclogs.www.process.study.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dynamiclogs.www.process.study.domain.Study;
import com.dynamiclogs.www.process.study.repository.StudyRepository;

@Controller
@RequestMapping(value="/study")
public class StudyController {
	
	@Autowired 
	private StudyRepository studyRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String study(Model model) {
		List<Study> studys = (List<Study>) studyRepository.findAllByOrderByRegDateAsc();
		model.addAttribute("studys", studys);
		return "contents/study";
	}
	
	@RequestMapping(headers="Content-Type=application/json", value="/save", method=RequestMethod.POST)
	public @ResponseBody Study saveStudy(@RequestBody Study studyBoard) {
		studyRepository.save(studyBoard);
		return studyBoard;
	}
	
}
