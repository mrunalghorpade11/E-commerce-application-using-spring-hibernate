<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>category page</title>
<%@ include file="/resources/static/head.jsp"%>
<style>
#div {
  background:blue;
  height: 100%;
  width: 100%;
}
</style>
</head>
<body>
<%@ include file="/resources/static/Navbar.jsp"%>



<c:forEach var="category" items="${cat}">
<table>
	<tr>
	<th><c:out value="${category.categoryName}"></c:out></th>
	</tr>
	<tr>
	<td>
	<img src="<c:url value="${category.imagePath}" context="/edu/resources"></c:url>" />
	</td>
	</tr>
	<tr>
	<a href="${contextPath}/product?category=${category.categoryName}">shop</a>
	</tr>
	</table>
</c:forEach>




 <!-- <div class="row">
    <div class="col-sm-4 lg">
    <img src="/resources/img/Kurta.jpg" alt="Indian Kurta">
    </div>
    <div class="col-sm-4 lg" >
    <img src="/resources/img/sari.jpg" alt="sari">
    </div>
    <div class="col-sm-4" >
    <img src="/resources/img/dress.jpg" alt="sari">
    </div>
  </div>
 -->
 
 
 
 
</body>
</html>