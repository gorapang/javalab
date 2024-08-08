/*
 브라우저 소통이 가능한 http 통신용 controller
 
 12단계 
 BoardController - main 컨트롤러 (중앙집중 front controller)
 	- spring 내부에서 제공
 	- DispatchServlet
 ~Action - sub 컨트롤러
 ActionFactory - 설정 파일
 	- spring 내부 설정 + application.properties(편집가능한 파일)
 */

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //일반 클래스를 http통신 가능한 servlet으로 변환
public class FirstSubController {
	
	//get 방식 요청 받고 데이터도 받는 service() 메소드 (doGet())
	@GetMapping("fisadata")
	public String m3(String data) {
		System.out.println("m3() " + data);
		return "너만의 데이터값 " + data;
	}
	
	//post 방식 요청 받고 데이터도 받는 service() 메소드 (= doPost())
	/*
	 SpringBoot가 People 데이터 객체 생성
	 - 기본 생성자 호출 -> setXxx (세터 이름을 반드시 지켜야 한다)
	 - name 변수로 인해 자동 호출되는 메소드 setName()
	 */
	@PostMapping("fisadata")
	public String m4(People data) { // People 데이터(이름, 나이) 받음
		System.out.println("m4() " + data);
		return "데이터 저장 성공";
	}
	
	//get 방식 요청 처리 메소드
	@GetMapping("fisa")
	public String m1() {
		return "spring";
	}
	
	//post 방식 (doPost() or service())
	@PostMapping("fisa")
	public People m2() {
		return new People("연아", 10); //dto 반환 시 멤벼변수는 key, 멤버변수 값은 value로 json
	}
}
