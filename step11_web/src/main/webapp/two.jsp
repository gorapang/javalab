<%@ page contentType="text/html; charset=utf-8" %>

<%		System.out.println("Twoì Service()");
		
		//client 가 서버에 전송한 데이터
		String id = request.getParameter("id"); 
		System.out.println("id : " + id);
		
		//One에서 저장한 새로운 데이터
		System.out.println(request.getAttribute("heart"));
%>
<%-- jsp만의 주석 --%>
<!-- html 주석 -->

<%-- id 값 브라우저에 출력
	out.println(request.getParameter("id"));
	heard 출력
	out.println(requeset.getAttribute("heart"));
	
	${} - 브라우저 출력 EL tag
	param.id = 동일한 순수 servlet code
		request.getParameter("id")
		request.getParameter("pw") = param.pw
		
	requestScope.heart
		requestScope : setAttribute() 로 저장한 데이터 착출시 사용되는 속성명 
		requestScope.heart :
			request.setAttribute("heart", "...")로 저장한 데이터 착축
			request.getAttribute("heart")와 동일한 코드
	
 --%>
 
${param.id}<br>
${requestScope.heart}<br>
$(requestScope.test} 