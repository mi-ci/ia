<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드</h1>
	<form action="process.jsp" method="post" ENCTYPE="multipart/form-data">
	<p>제목 : <input type="text" name="title">
	<p>파일 : <input type="file" name="fileName">
	<p> <input type="submit" value="send">
	</form>
</body>
</html>