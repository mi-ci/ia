<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="mb" class="jsp01.MemberBean" scope="page"/>
	
	<jsp:setProperty property="id" name="mb" value="20001213"/>
	<jsp:setProperty property="name" name="mb" value="박미자"/>
	
	<jsp:getProperty property="id" name="mb"/>	
	<jsp:getProperty property="name" name="mb"/>	
	
	<p> <%= mb.getId() %> <%= mb.getName() %>
	
</body>
</html>