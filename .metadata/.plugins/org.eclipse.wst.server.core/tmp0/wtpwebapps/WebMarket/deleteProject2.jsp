<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class = "jumbotron">
		<div class = "container">
			<h1 class="display-3 f1">상품 삭제</h1>		
		</div>
	</div>
	<div class="container">
		<form action="deleteProduct.jsp" method="post">
		<h3>삭제할 상품 순서 몇번째 :</h3> <input type="text" name="id">
		<input type="submit" value="확인">
		</form>
	</div>
</body>
</html>