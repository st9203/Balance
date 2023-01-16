package com.balance.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.balance.dto.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	final String FIND_NEW_ID = "SELECT COUNT(*) FROM IMAGE";
	
	Image findByNo(int no);
	
	@Transactional
	int deleteByNo(int no);
	
	@Query(value=FIND_NEW_ID,nativeQuery = true)
	int findNewId();
	
	List<Image> findByTitle(String title);
	List<Image> findByContent(String content);
	

}
