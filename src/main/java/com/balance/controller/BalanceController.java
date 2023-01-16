package com.balance.controller;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.balance.config.PrincipalDetails;
import com.balance.dto.Data;
import com.balance.dto.Image;
import com.balance.repository.DataRepository;
import com.balance.repository.ImageRepository;

@Controller
public class BalanceController {

	@Autowired
	DataRepository dataRepository;

	@Autowired
	ImageRepository imageRepository;
	
	@GetMapping({ "/", "/balance/index" })
	public ModelAndView main(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");

		return mav;
	}

	@PostMapping("/balance/upload")
	public ModelAndView mainTitle(Image img,List<MultipartFile> files) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");

		List<Image> fileList = new ArrayList<Image>();
		if(files.isEmpty()) {
			return mav;
		}
		
		// 파일명 날짜로 바꿔서 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String current_date = sdf.format(new Date());
		
		// 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (window의 톰캣은 Temp 파일을이용한다.)
		String absolutePath = new File("").getAbsolutePath()+"\\";
		
		String path = "images/"+current_date;
		File file = new File(path);
		
		// 저장할 위치의 디렉토리가 존재하지 않을 경우
		if(!file.exists()) {
			// mkdir() 함수와 다른점은 상위 디렉토리가 존재하지 않을때 그것까지 생성
			file.mkdirs();
		}
		
		for(MultipartFile multiFile :  files) {
			if(!multiFile.isEmpty()) {
				String contentType = multiFile.getContentType();
				String originalFile;
				if(ObjectUtils.isEmpty(contentType)) {
					break;
				}else {
					if(contentType.contains("image/jpeg")) {
						originalFile = ".jpg";
					}else if(contentType.contains("image/png")) {
						originalFile = ".png";
					}else if(contentType.contains("image/gif")) {
						originalFile = ".gif";
					}else {
						break;
					}
				}
				String new_file_name = Long.toString(System.nanoTime()) + originalFile;
				int newId = imageRepository.findNewId();
				
				Image imgFile = Image.builder()
						.id(newId)
						.day(new Date())
						.fileSize(multiFile.getSize())
						.storedFileName(path+"/"+new_file_name)
						.originalFileName(multiFile.getOriginalFilename())
						.build();
				fileList.add(imgFile);
				
				// 저장된 파일로 변경하여 이를 보여주기 위함
				file = new File(absolutePath + path + "/"+new_file_name);
				multiFile.transferTo(file);
			}
		}
		
//		URI uri = new URI("/img/"+);
		
		return mav;
	}

	@GetMapping("/balance/data")
	public ModelAndView push(HttpServletRequest req,@AuthenticationPrincipal PrincipalDetails pd) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("push");
		mav.addObject("role", pd.getRole());
		return mav;
	}

	@GetMapping("/balance/game")
	public ModelAndView game() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("game");

		return mav;
	}
	@GetMapping("")
	public ModelAndView startGame(@RequestParam String theme) {
		
		ModelAndView mav = new ModelAndView();
		List<Data> list = dataRepository.findByTheme(theme);
		System.out.println("List : "+list);
		mav.addObject("list", list);
		mav.setViewName("startGame");
		
		return mav;
	}

	@GetMapping("/balance/chat")
	public ModelAndView chat() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("chat");
		
		return mav;
	}
	
	@GetMapping("/balance/maps") 
	
	
	public String maps() {
			
		return "/balance/maps";
		
	}
	
	
	@PostMapping("/balance/data/insert")
	public ModelAndView push( Data data) {

		dataRepository.save(data);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/balance");
		return mav;
	}
	

}
