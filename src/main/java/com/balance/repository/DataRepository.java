package com.balance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balance.dto.Data;


public interface DataRepository extends JpaRepository<Data, Long> {

	List<Data> findByTheme(String theme);
}
