package step03.pagemove.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/loginTest")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginCheck doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginCheck doPost()");
		process(request, response);
	}

	//공통 로직으로 분리된 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step01- 쿠키 생성
		//Cookie 기술로 데이터 2가지 저장
		//실행 후 브라우저 쿠키 메모리 확인
		Cookie msg1 = new Cookie("msg1", "hi");
		Cookie msg2 = new Cookie("msg2", "fisa");
		
		msg1.setMaxAge(60*60*24); //초 단위 설정
		msg2.setMaxAge(60*60*24*365);
		
		response.addCookie(msg1);
		response.addCookie(msg2);
		
		//step02 - HttpSession 생성 및 데이터 저장
		/*
		 생성은 코드로 개발자가, 데이터 저장도 개발자가
		 단, 생성된 객체 관리는 컨테이너 내부의 로직이 함
		 */
		 /*
		 reqeust.getSession(): 없을 경우 생성, 이미 존재할 경우 제공
		 
		 */
		HttpSession session = request.getSession(); //client만의 고유한 요청 객체로부터 획득
		System.out.println("login: " + session.getId()); //컨테이너가 구분하기 위해 부여한 id
		//세션에 데이터 저장
		session.setAttribute("key1", "문자열");
		session.setAttribute("key1", 10); //new Integer(10)으로 오토박싱

		
		//redirect로 이동
		response.sendRedirect("view/welcome");
		
		//forward로 이동
		//request.getRequestDispatcher("view/welcome").forward(request, response);
	}
}
