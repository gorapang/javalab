package step02.pagemove;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Two")
public class Two extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Two의 service()");
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		System.out.println("요청 객체에 저장한 새로운 데이터: " + request.getAttribute("heart"));
	}

}
