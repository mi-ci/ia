<%@page import = "java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>headerInfo.jsp 파일</h3>
	<%
		String host = request.getHeader("host");
		String lang = request.getHeader("accept-language");
		
		out.println(host);
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName = en.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
	<%=headerName %> : <%=headerValue %> <hr>
	<%
		}	
	%>
	<br>
	<%= lang %>
	<br>
	<%= en %>
</body>
</html>