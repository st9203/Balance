package com.balance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.balance.dto.Board;
import com.balance.repository.BoardRepository;

@Controller
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	

	@GetMapping("/board")
	public ModelAndView boardList(@PageableDefault(size=2)Pageable pageable,
								  @RequestParam(required = false, defaultValue = "")String searchText) {
//		Page<Board> list =boardRepository.findAll(PageRequest.of(0, 20));
		Page<Board> boards =boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
		int startPage = Math.max(1, boards.getPageable().getPageNumber() -4);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		
		System.out.println("총 게시글 : "+boards.getTotalElements());
		System.out.println("시작페이지  : "+startPage);
		System.out.println("마지막페이지 : "+endPage);
		
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("boards", boards);
		
		mav.setViewName("board");
		return mav;
	}
	
	
//	@GetMapping("/board/detail")
//	public String boardDetail() {
//		return "/board";
//	}
//	@GetMapping("/board/write")
//	public String boardWrite() {
//		return "/board";
//	}
//	
//	@PostMapping("/board/insert")
//	public String boardInsert() {
//		return "redirect:/board";
//	}
//	@PostMapping("/board/search")
//	public String boardSearch() {
//		return "redirect:/board";
//	}
//
//	@DeleteMapping("/board/del")
//	public String boardDelete() {
//		return "redirect:/board";
//	}
	
}
