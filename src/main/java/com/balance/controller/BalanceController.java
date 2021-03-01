package com.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.balance.dto.Data;
import com.balance.repository.DataRepository;

@Controller
public class BalanceController {

	
	@Autowired
	DataRepository dataRepository;
	
	@GetMapping({"/","/index"})
	public String main() {
		System.out.println("Main페이지");
		return "index";
	}
	
	@GetMapping("/data")
	public String data() {
		return "push";
	}

	@PostMapping("/data/insert")
	public String push(Data data) {
		
		System.out.println("입력받은 DATA : "+data );
		
		return "redirect:/index";
	}
}
