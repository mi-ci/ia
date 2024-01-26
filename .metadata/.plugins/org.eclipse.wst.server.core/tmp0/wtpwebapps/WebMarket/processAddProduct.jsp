<%@page import="dao.ProductRepository"%>
<%@page import="dto.Product"%>
<%@ page import = "com.oreilly.servlet.*" %>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>processAddProject.jsp 상품등록 페이지</title>
</head>
<body>
	<jsp:useBean id="pr" class="dao.ProductRepository"></jsp:useBean>
	<%
		request.setCharacterEncoding("utf-8");
	
		String fileName = "";
		String realFolder = "C:\\ai\\study\\jsp_study\\WebMarket\\src\\main\\webapp\\images";
		int maxSize = 5*1024*1024;
		String encType = "utf-8";
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		
		String productId = multi.getParameter("productId");
		String pname = multi.getParameter("pname");
		String unitPrice = multi.getParameter("unitPrice");
		String description = multi.getParameter("description");
		String manufacturer = multi.getParameter("manufacturer");
		String category = multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getParameter("condition");
		Enumeration<String> files = multi.getFileNames();
		String fname = files.nextElement();
		String fileName1 = multi.getFilesystemName(fname);
		
		Integer price;
		Integer stocks;
		if(unitPrice.isEmpty()){
			price=0;
		}
		else{
			price = Integer.valueOf(unitPrice);
		}
		
		if(unitsInStock.isEmpty()){
			stocks=0;
		}
		else{
			stocks = Integer.valueOf(unitsInStock);
		}
	%>
	<%
		ProductRepository dao =  ProductRepository.getInstance();
		Product newProduct = new Product();
		newProduct.setProductId(productId);
		newProduct.setPname(pname);
		newProduct.setUnitPrice(price);
		newProduct.setDescription(description);
		newProduct.setManufacturer(manufacturer);
		newProduct.setCategory(category);
		newProduct.setUnitsInStock(stocks);
		newProduct.setCondition(condition);
		newProduct.setFilename(fileName1);
		dao.addProduct(newProduct);
		response.sendRedirect("Products.jsp");
	%>
</body>
</html>