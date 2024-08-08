package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//html -> controller -> jsp 등으로 실행에 권장 (동기, 비동기 혼용 / 현재는 동기)
//html <-> controller : 비동기 기술 적용 권장 (트렌드)
@Controller
public class StringReturnController {

    @RequestMapping(path="/fisa", method = RequestMethod.GET)
    public ModelAndView m0() {
        System.out.println("m0() ***");
        ModelAndView mv = new ModelAndView(); 
        
        //main.jsp에서 controller에서 저장한 데이터 출력
        mv.addObject("msg", "서버에서 저장한 데이터");
        mv.setViewName("main"); // /WEB-INF/main.jsp를 지정하는 설정
        return mv; //forward 방식
    }
    
    
    /* 
    forward와 redirect 방식 구분 
    index.html -> SubController -> main.jsp  
    */
    @RequestMapping(path="fisa1", method = RequestMethod.GET)
    public String m1() {
    	System.out.println("m1() ***");
    	
    	return "main"; // WEB-INT/main.jsp 정상 실행
    }
    
    
    //forward 방식으로 main으로 이동 (tester가 유지된다)
    @RequestMapping(path="fisa2", method = RequestMethod.GET)
    public String m2(@RequestParam("id") String id) {
    	System.out.println("m2() *** " + id);
    	return "main"; // WEB-INF/main.jsp 정상 실행
    }
    
    //redirect 방식으로 main.jsp로 이동
    //주의사항: 위치 WEB-INF가 아님
    //return "redirect:main.jsp"; 확장자 표기 필수
    @RequestMapping(path="fisa3", method = RequestMethod.GET)
    public String m3(@RequestParam("id") String id) {
    	System.out.println("m3() *** " + id);
    	return "redirect:main.jsp"; 
    }
    
    
    @RequestMapping(path="fisa4", method = RequestMethod.GET)
    public String m4(@RequestParam("id") String id) {
    	System.out.println("m4() *** " + id);
    	return "forward:main.jsp"; 
    }
    
    
}

/*
ModelAndView: 데이터, 화면
*/
