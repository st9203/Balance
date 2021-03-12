package com.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balance.dto.User;


//CRUD 함수를 JpaRepository가 들고있음
// @Repository라는 어노테이션이 없어도 IoC 가능 Jpa를 상속했기때문에
public interface UserRepository extends JpaRepository<User, Long>{

	
	// findBy규칙 -> Username문법
	public User findByUsername(String username);
	
}
