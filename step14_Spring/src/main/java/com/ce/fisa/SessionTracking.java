package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;

@Controller
/*
세션 기반의 개발 코드
1. HttpSession API
2. Spring API
	- key를 사전에 등록해야함
 */
@RequestMapping("sessiontracking")
@SessionAttributes({"id", "pw"})
public class SessionTracking {
	
	//logout2
	@GetMapping("/logout2") //@SessionAttributes 선언으로 사용한 세션 소멸
	public String m5(SessionStatus status) {
		status.setComplete();
		System.out.println("m5(): 세션 소멸 성공");
		return "redirect:/sessionView.jsp";
	}
	
	
	/*
	 Spring API로 작업시 
	 1단계: class 선언구에 사용하고자 하는 세션 key명 등록 @SessionAttributes({"id", "pw"})
	 2단계: Controller에서 이미 설정한 key로 데이터 획득 @ModelAttribute("id") String id
	
	 이렇게 등록한 세션은 HttpSession 로그아웃으로 삭제되지 않는다
	 */
	//sessiontest2
	@GetMapping("/sessiontest2")
	public String m4(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw) {
		System.out.println("m4(): " + id + ' ' + pw);
		return "redirect:/sessionView.jsp";
	}
	
	//sessiontracking/logout1 버튼 클릭 시 HttpSession API로 생성된 세션 삭제
	// ? invalidate()
	@GetMapping("/logout1")
	public String m3(HttpSession session) {
		System.out.println("m3(): " + session.getAttribute("id"));
		session.invalidate();
		session = null;
		return "redirect:/sessionView.jsp";
	}
	
	
	//SessionTracking.jsp -> SessionTracking.java -> SessionView.jsp
	//생성 및 데이터 저장 	  -> 생성된 세션 공유해서 받음   -> 생성된 세션 공유해서 받음 
	
	//HttpSession API를 사용한 개발 기술
	@GetMapping("/sessiontest")
	public String m2(HttpSession session) {
		System.out.println("m2(): " + session.getAttribute("id"));
		return "redirect:/sessionView.jsp";
	}
	
	@GetMapping("/cookietest")
	public String m1(@CookieValue("id") String value) {
		System.out.println("m1() --- " + value);
		return "redirect:/cookieView.jsp";
	}
}

