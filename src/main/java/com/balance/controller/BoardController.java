package com.balance.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView boardList(@PageableDefault(size=5,sort="no",direction = Sort.Direction.DESC)Pageable pageable,
								  @RequestParam(required = false, defaultValue = "")String searchText) {
		Page<Board> boards =boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
//		int startPage = Math.max(1, boards.getPageable().getPageNumber() -4);
//		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		
//		Page<Board> boards =boardRepository.findAll(pageable);
		System.out.println("페이지 : "+boards.getPageable());
		System.out.println("컨텐츠 : "+boards.getContent());
//		List<Board> boards = paging.getContent();
//		System.out.println("시작페이지  : "+startPage);
//		System.out.println("마지막페이지 : "+endPage);
		
		
		ModelAndView mav = new ModelAndView();

//		mav.addObject("startPage", startPage);
//		mav.addObject("endPage", endPage);
		mav.addObject("boards", boards);
		
		mav.setViewName("/list");
		return mav;
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model,int no) {
		Board board = boardRepository.findByNo(no);
		System.out.println("게시글 정보 : "+board);
		model.addAttribute("board", board);
		return "/detail";
	}
	
	
	@GetMapping("/board/write")
	public String boardWrite() {
		return "/write";
	}
	
	@PostMapping("/board/insert")
	public String boardInsert(Board board,Session sesion) {
		if(board != null) {
//			if()
			
			// 세션을 받아서 작성자명 바꾸기
			Date date = new Date();
			board.setAuth("테스트");
			board.setDay(date);
			
			System.out.println("입력된 게시글 : "+board);
			boardRepository.save(board);
			
		}else {
			System.out.println("입력된 게시글 : NULL");
		}
		
		return "redirect:/board";
	}
//	@PostMapping("/board/search")
//	public String boardSearch() {
//		return "redirect:/board";
//	}
//
	@GetMapping("/board/del")
	public String boardDelete(int no) {
		if(boardRepository.deleteByNo(no) == 1) {
			System.out.println(no+"번 게시글 삭제 성공");
		}else {
			System.out.println(no+"삭제 실패");
		}
		return "redirect:/board";
	}
	
}
