package com.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.balance.dto.User;
import com.balance.repository.UserRepository;

@Controller
public class LoginController {

	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/login/loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "/login/joinForm";
	}

	@PostMapping("/join")
	public String join(User user) {
		System.out.println(user);
		user.setRole("ROLE_USER");
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword); 
		user.setPassword(encPassword);
		userRepository.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}

}
