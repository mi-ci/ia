<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String result;
		
		if (id.equals("abcd") && pw.equals("1234")){
			result = "로그인에 성공하셨습니다";
		}
		else {
			result = "로그인에 실패했습니다";
		}
	%>
	<%= result %>
</body>
</html>