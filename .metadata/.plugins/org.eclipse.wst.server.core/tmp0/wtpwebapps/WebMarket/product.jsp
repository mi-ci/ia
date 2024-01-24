<%@ page import="dto.Product" %>
<%@ page import="dao.ProductRepository" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<script type="text/javascript">
	function addToCart(){
		if( confirm("상품을 장바구니에 추가하시겠습니까?")){
			document.addForm.submit();
		}
		else{
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>	
	<div class = "jumbotron">
		<div class = "container">
			<h1 class="display-3">상세 정보</h1>		
		</div>
	</div>
	
	<jsp:useBean id="pr" class="dao.ProductRepository"></jsp:useBean>
	<%
		ProductRepository dao = ProductRepository.getInstance();
		String id = request.getParameter("id");
		Product p = dao.getProductById(id);
		
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="${pageContext.request.contextPath}/images/<%= p.getFilename()%>" style="width:100%">
			</div>
			<div class="col-md-6">
				<h3><%=p.getPname() %></h3>
				<p><%=p.getDescription() %></p>
				<p><b>상품코드 : </b><a href="product.jsp?id=<%=p.getProductId() %>"> <span class="badge badge-danger"> <%=p.getProductId() %></span></a></p>
				<p><b>제조사 : </b><span class="badge text-bg-info"><%=p.getManufacturer() %></span></p>
				<p><b>분 류 : </b><%=p.getCategory() %></p>
				<p><b>재고수 : </b><%=p.getUnitsInStock() %></p>
				<p><b>상품상태 : </b><%=p.getCondition() %></p>
				<h4><%=p.getUnitPrice() %>원</h4>
				<p>
				<form name="addForm" action="addCart.jsp?id=<%=p.getProductId() %>" method="post">
				<p><a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
				<a href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
				<a href="Products.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
				</form>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>