<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>옛날 메이플 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
body{
background-color : #111111;
}
p, h3, h4, hr{
color : white;
}
.contain{
margin-bottom:100px;
}
.little_margin_bottom{
margin-bottom:50px;
}
a{
text-decoration-line : none;
}
a:hover {
color: #00ee00;
text-shadow: 0 1px 2px #00ff00;
}

</style>
</head>
<body>
	<nav class ="navbar navbar-expand navbar-dark bg-dark"> 
	 	<div class= "container">
	 		<div class = "navbar-header">
	 			<a class = "navbar-brand" href="main.jsp"><img src="images/logo.jpg" style="width:20%"> OLD PLANET</a>
	 		</div>
	 		<div class = "navbar-header">
	 			<a class = "navbar-brand" href="Products.jsp">몬스터</a>
	 			<a class = "navbar-brand" href="addProduct.jsp">아이템</a>
	 			<a class = "navbar-brand" href="deleteProject2.jsp">맵</a>
	 		</div>
		</div>
	</nav>
	
	<div class="text-center">
	  	<div class="row little_margin_bottom">
	    	<div class="col">
	      		
	    	</div>
	    	<div class="col-6">
	    		<br>
	    		<br>
	      		<h3>몬스터</h3>
	      		<hr>
	    		<br>
	    		<br>
	      		<div class="row contain">
		      		<div class="col">
		      			<a href="level1_20.jsp">
		      			<img src="images/bluesnail.jpg" style="width:20%">
		      			<h4>레벨 1-20</h4>
		      			</a>
		      		</div>
		      		<div class="col">
		      			<img src="images/wildboar.jpg" style="width:30%">
		      			<h4>레벨 21-40</h4>
		      		</div>
		      		<div class="col">
		      			<img src="images/wraith.jpg" style="width:25%">
		      			<h4>레벨 41-60</h4>
		      		</div>
	      		</div>
	      		<div class="row contain">
		      		<div class="col">
		      			<img src="images/tauro.jpg" style="width:30%">
		      			<h4>레벨 61-80</h4>
		      		</div>
		      		<div class="col">
		      			<img src="images/viking.jpg" style="width:20%">
		      			<h4>레벨 81-100</h4>
		      		</div>
		      		<div class="col">
		      			<img src="images/skele.jpg" style="width:20%">
		      			<h4>레벨 101~</h4>
		      		</div>
	      		</div>
	    		<br>
	    		<br>
	      		<h3>아이템</h3>
	      		<hr>
	    		<br>
	    		<br>
	      		<div class="row contain">
		      		<div class="col">
		      			<img src="images/ohs.jpg" style="width:20%">
		      			<h4>장비</h4>
		      		</div>
		      		<div class="col">
		      			<img src="images/elixer.jpg" style="width:20%">
		      			<h4>소비</h4>
		      		</div>
		      		<div class="col">
		      			<img src="images/etc.jpg" style="width:20%">
		      			<h4>기타</h4>
		      		</div>
	      		</div>
	    		<br>
	    		<br>
	      		<h3>맵</h3>
	      		<hr>
	    		<br>
	    		<br>
	      		<div class="row contain">
		      		<div class="col">
		      			<h4>메이플 아일랜드</h4>
		      		</div>
		      		<div class="col">
		      			<h4>빅토리아</h4>
		      		</div>
		      		<div class="col">
		      			<h4>엘나스</h4>
		      		</div>
	      		</div>
	    	</div>
	    	<div class="col">
	      		
	    	</div>
	  	</div>
  	</div>
  	
  	<hr>
	<footer class = "container text-center">
		<p>&copy; 2024 OLD PLANET</p>
		<p>OLD PLANET은 NEXON KOREA와 관련 없습니다.</p>
		<p>모든 정보와 이미지의 저작권은 NEXON KOREA에 있습니다.</p>
		<p>OLD PLANET은 정보공유를 목적으로 만든 팬사이트입니다.</p>
		<p>OLD PLANET에서 보시는 광고는 사이트와 서버를 유지보수하기 위해 사용됩니다.</p>
	</footer>

</body>
</html>