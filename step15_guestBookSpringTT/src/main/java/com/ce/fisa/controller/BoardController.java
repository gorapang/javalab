package com.ce.fisa.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;

/*
브라우저 화면에 데이터 출력 시 사용되는 API
하단 코드 상에서는 요청 객체처럼 사용
사용방법
- 요청 객체를 jsp로 forward하고자하는 메소드 구현 시 parameter로 선언
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ce.fisa.model.guestbook.GuestBookBean;
import com.ce.fisa.model.guestbook.GuestBookDAO;

@Controller
public class BoardController {

	@GetMapping("list") // command=list
	public ModelAndView execute() throws SQLException {
		System.out.println("++++++++++++++++++");
//		if(true) {
//			throw new SQLException("db연동 이슈");
//		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", GuestBookDAO.getAllContents());
		mv.setViewName("list"); // /WEB-INF/list.jsp 의미
		return mv;
	}

	@GetMapping("view")
	public ModelAndView view(@RequestParam("num") int num) throws Exception { // String -> int
		ModelAndView mv = new ModelAndView();

		GuestBookBean gContent = GuestBookDAO.getContent(num, true);

		if (gContent == null) { //controller <-> service <-> dao 구조로 전환 시 if~else 삭제 예정
			throw new Exception("게시물이 존재하지 않습니다.");
		} else {
			mv.addObject("resultContent", gContent);
		}
		mv.setViewName("read");
		return mv;
	}

	/*
	 * 예외 전담 메소드 1. 장점 - 코드에 예외 처리 코드의 필수이나 중복 및 지저분 - 예외 처리 전담 메소드 or 예외 전담 클래스 별도로
	 * 개발 - @ExceptionHandler
	 */
	@ExceptionHandler
	public String exceptionProcess(SQLException e, Model message) {
		System.out.println("*************");
		e.printStackTrace();
		message.addAttribute("errorMsg", e.getMessage());
		return "forward:/error.jsp";
	}

}