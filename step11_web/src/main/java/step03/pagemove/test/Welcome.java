package step03.pagemove.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome doPost()");
		process(request, response);
	}

	//공통 로직으로 분리된 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//step01- cookie 정보 client 브라우저로부터 획득해서 출력
		//해당 Domain의 쿠키 정보만 획득
//		Cookie[] all = request.getCookies();
//		
//		for (Cookie c: all) {
//			if (c.getName().equals("msg1")) {
//				out.println(c.getValue() + "<br>");
//			}
//		}
		
		

		
		//step02 - 존재하는 session 받아오기
		HttpSession session = request.getSession(); //client만의 고유한 요청 객체로부터 획득
		System.out.println("welcome: " + session.getId()); //컨테이너가 구분하기 위해 부여한 id
		
		//세션 데이터 활용 (브라우저에 10 출력)
		out.println(session.getAttribute("key1"));
		

        // 로그아웃 클릭 시에 쿠키정보 삭제하고 login.html로 이동되는 servlet으로 이동
        /*
         login.html -> LoginCheck -> Welcome: 쿠키데이터 확인 -> Logout: 로그아웃 -> login.html
         */

        // url 표기에 /로 시작할 경우 https://ip:port까지를 의미
        out.println("<a href='" + request.getContextPath() + "/logout'>");
        out.println("logout</a>");
        out.close();
		

//		//out.println("<a href='../html/login.html'>");
//		//out.println("<a href='/step11_web/html/login.html'>"); 
//		out.println("<a href='" + request.getContextPath() + "/html/login.html'>");
//		out.println("login 화면으로 이동</a>");
		out.close();
		out = null;
	}
}
