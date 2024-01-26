<%@page import="dto.Product"%>
<%@page import="dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<jsp:useBean id="p" class="dto.Product"></jsp:useBean>
	<jsp:useBean id="pr" class="dao.ProductRepository"></jsp:useBean>
	<%@ include file="menu.jsp" %>
	<%! String greeting = "Welcome to Web Shopping Mall"; 
		String tagline = "Welcome to Web Market~!";
	%>
	<div class = "jumbotron">
		<div class = "container">
			<h1 class="display-3"><%= greeting %></h1>		
		</div>
	</div>
	
	<main role = "main">
		<div class = "container">
			<div class = "text-center">
				<h3><%= tagline %></h3>
				<a href="Products.jsp">
					<img src="images/giphy1.gif" alt="redsnail" class="img-thumbnail">
				</a>			

			<%
				Date day = new Date();
				String am_pm;
				int year = day.getYear()+1900;
				int month = day.getMonth()+1;
				int day2 = day.getDate();
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();
				if (hour/12==0) {
					am_pm = "AM";
				}
				else {
					am_pm = "PM";
					hour = hour - 12;
				}
				String cd = year + "/" + month + "/" + day2;
				String ct = hour + ":" + minute + ":" + second + " " + am_pm;
				
			%>
			<h5>방문날짜 <%=cd %></h5>
			<h5>방문시간 <%=ct %></h5>
			</div>
		</div>
		
	</main>
	
	
	<%@ include file="footer.jsp" %>

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>