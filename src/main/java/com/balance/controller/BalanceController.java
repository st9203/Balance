package com.balance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.balance.dto.Data;
import com.balance.repository.DataRepository;

@Controller
public class BalanceController {

	
	@Autowired
	DataRepository dataRepository;
	
	@GetMapping({"/","/index"})
	public ModelAndView main() {
		System.out.println("Main페이지");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		return mav;
	}
	
	@GetMapping("/data")
	public ModelAndView push() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("push");
		return mav;
	}

	@GetMapping("/game")
	public ModelAndView game() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("game");
		
		return mav;
	}
	@GetMapping("/game/start")
	public ModelAndView startGame(@RequestParam String theme) {
		
		ModelAndView mav = new ModelAndView();
		List<Data> list = dataRepository.findByTheme(theme);
		System.out.println("List : "+list);
		mav.addObject("list", list);
		mav.setViewName("startGame");
		
		return mav;
	}

	@GetMapping("/chat")
	public ModelAndView chat() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("chat");
		
		return mav;
	}
	
	
	@PostMapping("/data/insert")
	public ModelAndView push(Data data) {
		
		System.out.println("입력받은 DATA : "+data.toString() );
		dataRepository.save(data);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index");
		return mav;
	}
	
}
