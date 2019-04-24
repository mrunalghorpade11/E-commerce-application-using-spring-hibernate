<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/resources/static/head.jsp"%>
<title>This page is to display kurtas</title>
</head>
<body>
<%@ include file="/resources/static/Navbar.jsp"%>
kurta options here


<c:forEach var="product" items="${product}">
<c:set var = "name" scope = "session" value="${product.productName}"/>
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
	<td>
	<a href="${contextPath}/product/order?category=kurta&productName=${name}">Order this</a>
	</td>
	</tr>
	
	</table>
</c:forEach>

</body>
</html>