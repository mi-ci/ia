<%@page import="dao.ProductRepository"%>
<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="pr" class="dao.ProductRepository"></jsp:useBean>
	<%
		ProductRepository dao = ProductRepository.getInstance();
		String id = request.getParameter("id");
		Integer ind;
		if(id.isEmpty()){
			ind=0;
		}
		else{
			ind = Integer.valueOf(id);
		}
		dao.getLop().remove(ind-1);
		response.sendRedirect("Products.jsp");
	%>

</body>
</html>