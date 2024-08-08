package step03.pagemove.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout doGet()");
		//process(request, response); //쿠키 정리
		process2(request, response); //세션 정리
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout doPost()");
		//process(request, response);
		process2(request, response);
	}

	//step02: HttpSession 정리하는 메소드
	protected void process2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 삭제
		HttpSession session = request.getSession();
		System.out.println("logout: " + session.getId());
		session.invalidate(); //세션객체 무효화, 기능 상실(중요)
		session = null;
		
		
		response.sendRedirect("html/login.html");
	}
	
	//step01: 쿠키 정리하는 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client 쿠키 정보 삭제(페이지 이동 없이 유저가 모르게) -> login.html로 이동
		
		Cookie[] all = request.getCookies();
		
		for (Cookie c: all) {
			if (c.getName().equals("msg1")) { //쿠키 key값 뽑아 비교
				c.setValue(""); //c.setValue(null);

                c.setMaxAge(0); // 쿠키 삭제를 위해 유효 기간을 0으로 설정
                response.addCookie(c);
			}
		}
		
		//response.sendRedirect("html/login.html"); 
		// login.html로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/html/login.html");
	}

}
