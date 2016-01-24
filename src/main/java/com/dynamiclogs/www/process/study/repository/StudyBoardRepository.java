package com.dynamiclogs.www.process.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dynamiclogs.www.process.study.domain.StudyBoard;

/**
 * 
 * 연구게시판 레파지토리 클래스입니다.
 *
 * com.dynamiclogs.www.process.repository
 * StudyBoardRepository.java
 *
 * @author : quickmenu
 * @date : 2016. 1. 1.
 * @version : 1.0
 *
 */
public interface StudyBoardRepository extends JpaRepository<StudyBoard, Integer> {
	
	// 처음으로 생성한 jpa 쿼리 메소드
	List<StudyBoard> findAllByOrderByRegDateAsc();
	
}
