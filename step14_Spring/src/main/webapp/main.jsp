<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% System.out.println("*** jsp에서 출력 ***"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	WEB-INF 폴더가 아님 ${requestScope.msg} --- ${param.id} ---
</body>
</html>