<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="jsp01.Person" scope="page"></jsp:useBean>
	<h1>Person 자바 자료 입력하고 출력하기</h1><br>
	<p> 이름 나이 주소
	<br>

	<jsp:setProperty property="name" name="p" value="이수진"/>
	<jsp:setProperty property="age" name="p" value="25"/>
	<jsp:setProperty property="addr" name="p" value="서울"/>
	
	<jsp:getProperty property="name" name="p"/>
	<jsp:getProperty property="age" name="p"/>
	<jsp:getProperty property="addr" name="p"/>
	
	<br>
	
	<jsp:setProperty property="name" name="p" value="정수진"/>
	<jsp:setProperty property="age" name="p" value="27"/>
	<jsp:setProperty property="addr" name="p" value="인천"/>
	
	<jsp:getProperty property="name" name="p"/>
	<jsp:getProperty property="age" name="p"/>
	<jsp:getProperty property="addr" name="p"/>
	
	<br>
	
</body>
</html>