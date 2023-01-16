package com.balance.controller;


import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.balance.config.PrincipalDetails;
import com.balance.dto.Board;
import com.balance.repository.BoardRepository;

@Controller
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	

	@GetMapping("/balance/board")
	public ModelAndView boardList(@PageableDefault(size=5,sort="no",direction = Sort.Direction.DESC)Pageable pageable,
								  @RequestParam(required = false, defaultValue = "")String searchText) {
		Page<Board> boards =boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
//		int startPage = Math.max(1, boards.getPageable().getPageNumber() -4);
//		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		
//		Page<Board> boards =boardRepository.findAll(pageable);
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
	
	@GetMapping("/balance/board/detail")
	public ModelAndView boardDetail(int no) {
		Board board = boardRepository.findByNo(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("/detail");
		return mav;
	}
	
	
	@GetMapping("/balance/board/write")
	public String boardWrite() {
		return "/write";
	}
	
	@Transactional
	@PostMapping("/balance/board/insert")
	public String boardInsert(Board board,@AuthenticationPrincipal PrincipalDetails pd) {
		if(board != null) {
			// 세션을 받아서 작성자명 바꾸기
			board.setAuth(pd.getUsername());
			board.setDay(new Date());
			
			boardRepository.save(board);
			
		}
		
		return "redirect:/balance/board";
	}
//	@PostMapping("/board/search")
//	public String boardSearch() {
//		return "redirect:/board";
//	}
	
	@Transactional
	@GetMapping("/balance/board/del")
	public String boardDelete(int no) {
		boardRepository.deleteByNo(no);
		return "redirect:/balance/board";
	}
	
	@GetMapping("/balance/board/modify")
	public ModelAndView boardModify(int no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modify");
		mav.addObject("board",boardRepository.findByNo(no));
		return mav;
	}
	
	@Transactional
	@PostMapping("/balance/board/modify")
	public ModelAndView boardModify(Board board,@AuthenticationPrincipal PrincipalDetails pd) {
		ModelAndView mav = new ModelAndView();
		if(board != null) {
			// 세션을 받아서 작성자명 바꾸기
			board.setAuth(pd.getUsername());
			board.setDay(new Date());
			boardRepository.updateBoard(board.getNo(),board.getAuth(),board.getTitle(),board.getContent(),board.getDay());
		}
		mav.setViewName("/detail");
		return mav;
	}
	
}
