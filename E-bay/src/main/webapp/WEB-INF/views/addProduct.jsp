<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/resources/static/head.jsp"%>
<title>Insert title here</title>
<%@ include file="/resources/static/Navbar.jsp"%>
</head>
<body>
<div class="container">
<form:form action="addProduct.htm" method="POST" commandName="Product" modelAttribute="addProduct">
<fieldset>
	<div class="form-group">
	  <label class="col-md-4 control-label">Product Name</label>  
	  
		  <form:input class="form-control input-md" path="productName" name="productName"></form:input>
		  <form:errors path="productName"></form:errors>
	  
	</div>
	
	<div class="form-group">
		<label class="col-md-4 control-label">Price</label>
		
		<form:input path="price" name="price" class="form-control"></form:input>
		<form:errors path="price"></form:errors>
		
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label">Quantity</label>
		
		<form:input path="quantity" name="quantity" class="form-control"></form:input>
		<form:errors path="quantity"></form:errors>
		
	</div>
	
	<div class="form-group">
		<label class="col-md-4 control-label">Image Path</label>
		
		<form:input path="imagePath" name="imagePath" class="form-control"></form:input>
		<form:errors path="imagePath"></form:errors>
		
	</div>
	
	
	
	<input type="submit" name="submit" value="submit"
					class="btn-success btn" />

</fieldset>
</form:form>


</div>
</body>
</html>