<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>날짜 함수 지원하는 자바 연결하기</h3><br>
	<jsp:useBean id="d1" class="java.util.Date"></jsp:useBean>
	<%
		int date = d1.getDate();
		int hour = d1.getHours();
	%>
	<p> <%= date %>일 <%= hour %>시
	
	
	
	<h3>수학 지원하는 자바 연결하기</h3><br>	
	<%
		int a1 = java.lang.Math.abs(-100);
		int max1 = java.lang.Math.max(10, 20);
	%>
	
	<p> <%= a1 %>
	<p> <%= max1 %>
	
	<h3>어레이 리스트</h3><br>
	<jsp:useBean id="ar" class="java.util.ArrayList"></jsp:useBean>
	<%
		ar.add("사과");
		ar.add("배");
		ar.add("귤");
		ar.add("사과");
		String aa = (String) ar.get(1);
		int total = ar.size();
		
	%>
	
	<p> <%= ar.get(1) %> <%= aa %>
	<p> 전체 판매 과일 갯수는 <%=total  %>개
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>