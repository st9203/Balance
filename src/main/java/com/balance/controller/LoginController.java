package com.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balance.dto.User;
import com.balance.repository.UserRepository;

@Controller
public class LoginController {

	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "/login/loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "/login/joinForm";
	}

	@PostMapping("/join")
	@ResponseBody
	public String join(User user) {
		User newUser = null; 
		newUser = userRepository.findByUsername(user.getUsername());
		System.out.println(user);
		System.out.println(newUser);
		if(newUser == null) {
			user.setRole("ROLE_USER");
			String rawPassword = user.getPassword();
			String encPassword = bCryptPasswordEncoder.encode(rawPassword); 
			user.setPassword(encPassword);
			userRepository.save(user);
			return "success";
		}else {
			return "fail";
			
		}
	}
	
	
	@PostMapping("/checkId")
	@ResponseBody
	public String checkUserName(String username) {
		return userRepository.checkUsername(username);
	}
	
	
	
	
}
