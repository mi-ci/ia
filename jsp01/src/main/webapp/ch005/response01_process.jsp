<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>response01_process.jsp file</h3>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("admin") && pw.equals("1234")){
			response.sendRedirect("response01_success.jsp");
		}
		else if(id.equals("google")){
			response.sendRedirect("https://google.com");
		}
		else {
			response.sendRedirect("response01_fail.jsp");			
		}
	%>
</body>
</html>