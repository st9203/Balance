package com.balance.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.balance.dto.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	public static final String UPDATE_BOARD = "UPDATE BOARD SET AUTH=:auth,TITLE=:title,CONTENT=:content,DAY=:day WHERE NO = :no";
	
	
	Board findByNo(int no);
	@Transactional
	int deleteByNo(int no);
	
	List<Board> findByTitle(String title);
	List<Board> findByContent(String content);
	
	@Modifying 
	@Transactional
	@Query(value=UPDATE_BOARD,nativeQuery = true)
	int updateBoard(int no,String auth,String title, String content, Date day);
	
	Page<Board> findByTitleContainingOrContentContaining(String title, String content,Pageable pageable);

}
