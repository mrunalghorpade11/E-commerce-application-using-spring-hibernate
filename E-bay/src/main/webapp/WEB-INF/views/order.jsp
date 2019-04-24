<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/resources/static/head.jsp"%>
<title>User Order</title>
</head>
<body>
<%@ include file="/resources/static/Navbar.jsp"%>

your order appears here..!!!

<c:forEach var="product" items="${product}">
<table>
	<tr>
	<td>
	<img src="<c:url value="${product.imagePath}" context="/edu/resources"></c:url>" />
	</td>
	</tr>
	<tr>
	<th> Product Name :<c:out value="${product.productName}"></c:out></th>
	</tr>
	<tr>
	<td> Quantity available: <c:out value = "${product.quantity }" ></c:out> pieces </td>
	</tr>
	<tr>
	<td>price: $<c:out value = "${product.price}"></c:out></td>
	</tr>
	<tr>
	</tr>
	
	</table>
</c:forEach>
	<form action= "${contextPath}/product/order/placed" method="GET">
		Select Quantity 
		<select name = "quantity">
		<option value = 1>1</option>
		<option value = 2>2</option>
		</select>
		<br>
		<input type="submit" value="place order">
		</form>

			


</body>
</html>