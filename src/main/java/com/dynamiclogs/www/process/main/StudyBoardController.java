package com.dynamiclogs.www.process.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dynamiclogs.www.process.domain.StudyBoard;
import com.dynamiclogs.www.process.repository.StudyBoardRepository;

@RestController
@RequestMapping(value="/study")
public class StudyBoardController {
	
	@Autowired private StudyBoardRepository studyBoardRepository;
	
	@RequestMapping(headers="Content-Type=application/json", value="/save", method=RequestMethod.POST)
	public @ResponseBody StudyBoard saveStudyContent(@RequestBody StudyBoard studyBoard) {
		System.out.println(studyBoard.toString());
		studyBoardRepository.save(studyBoard);
		return studyBoard;
	}
	
}
