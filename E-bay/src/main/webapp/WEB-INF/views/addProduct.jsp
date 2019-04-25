<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add products</title>
<%@ include file="/resources/static/head.jsp"%>
</head>
<body>
<%@ include file="/resources/static/Navbar.jsp"%>

<form action ="/supplierAction.htm" method = "POST">
	Product Name<input type = "text" name = "productName"><br>
	Product Price<input type = "text" name = "ProductPrice"></br>
	Product quantity <input type = "text" name = "quantity"></br>
	Category 
	<select name = "category">
		<option value = "1" >1</option>
		<option value = "2">2</option>
		<option value = "3">3</option>
	</select>
	<input type = "submit" value = "submit">
</form>


</body>
</html>