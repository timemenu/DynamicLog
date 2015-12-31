package com.dynamiclogs.www.process.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.dynamiclogs.www.process.domain.StudyBoard;

public interface StudyBoardRepository extends Repository<StudyBoard, Integer> {
	
	// 처음으로 생성한 jpa 쿼리 메소드
	List<StudyBoard> findTop3ByOrderByRegDateAsc();
	
}
