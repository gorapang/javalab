package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//html -> controller -> jsp등으로 실행에 권장(동기방식과 비동기 혼용)
//html <-> controller : 비동기 기술 적용 권장(트렌드)
//현업구조 : 혼용
@Controller
public class StringReturnController {
	
	//http://localhost/step14/fisa
	@RequestMapping(path="/fisa", method = RequestMethod.GET)
	public ModelAndView m1() {
		System.out.println("m1() *****");
		ModelAndView mv = new ModelAndView();
		//main.jsp에서 controller에서 저장한 데이터 출력
		//request.setAttribute("msg", "서버에서 저장한 데이터");
		mv.addObject("msg", "서버에서 저장한 데이터"); 
		mv.setViewName("main");  // /WEB-INF/main.jsp 지정하는 설정 
		
		/* request.getRequestDispacher("main.jsp").forward(request, response); */
		return mv; //forward
	}
	
	/* forward와 redirect 방식 구분 
	 * index.html -> SubController -> main.jsp
	 */
	@RequestMapping(path="fisa1", method = RequestMethod.GET)
	public String m2() {
		System.out.println("m2() ***");
		return "main"; //WEB-INF/main.jsp 정상실행
	}
		
	//foward 방식으로 main 으로 이동
	@RequestMapping(path="fisa2", method = RequestMethod.GET)
	public String m22(@RequestParam("id") String id) {
		System.out.println("m22() ***" + id);
		return "main"; //WEB-INF/main.jsp 정상실행
	}
	
	//redirect 방식으로 main.jsp로 이동
	//주의 사항 : 위치 = WEB-INF아님
	//return "redirect:main.jsp" 확장자 표기 필수
	@RequestMapping(path="fisa3", method = RequestMethod.GET)
	public String m3(@RequestParam("id") String id) {
		System.out.println("m3() ***" + id);
		return "redirect:main.jsp"; //WEB-INF/main.jsp 정상실행
	}
	
	@RequestMapping(path="fisa4", method = RequestMethod.GET)
	public String m4(@RequestParam("id") String id) {
		System.out.println("m3() ***" + id);
		return "forward:main.jsp"; //WEB-INF/main.jsp 정상실행
	}
	
	
}
/*
 * ModelAndView : 데이터, 화면  
 * */
