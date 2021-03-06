package com.balance.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balance.dto.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	Board findByNo(int no);
	@Transactional
	int deleteByNo(int no);
	
	List<Board> findByTitle(String title);
	List<Board> findByContent(String content);
	
	
	Page<Board> findByTitleContainingOrContentContaining(String title, String content,Pageable pageable);

}
