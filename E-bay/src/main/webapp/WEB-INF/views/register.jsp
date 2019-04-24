<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/resources/static/head.jsp"%>
<title>Register page</title>
</head>
<body>
<%@ include file="/resources/static/Navbar.jsp"%>

<div class="container">
		<div class="col-md-4 col-md-offset-4 col-xs-12 col-lg-4 col-lg-offset-4 col-sm-12 well well-sm">
		
		<form:form action="register.htm" method="POST" commandName="Customer" modelAttribute="customer">
				
				<div class="form-group">
					<label>First Name:</label>
					<form:input path="fname" name="fname" class="form-control"></form:input>
					<form:errors path="fname"></form:errors>
				</div>
				
				<div class = "form-group">
					<label>Last Name:</label>
					<form:input path="lname" name="lname" class="form-control"></form:input>
					<form:errors path="lname"></form:errors>
				</div>
				
				<div class = "form-group">
					<label> Phone Number</label>
					<form:input path="phoneNumber" name="phoneNumber" class="form-control"></form:input>
					<form:errors path="phoneNumber"></form:errors>
				</div>
				
				<div class = "form-group">
					<label>User Name</label>
					<form:input path="userName" name="userName" class="form-control"></form:input>
					<form:errors path="userName"></form:errors>
				</div>
				
				<div class = "form-group">
					<label>Password</label>
					<form:input path="password" name="password" class="form-control"></form:input>
					<form:errors path="password"></form:errors>
				</div>
				
				 <div class = "form-group">
				<label>Role</label>
				<form:select path="role">
		            <form:option value="supplier" label="supplier" />
		            <form:option value="customer" label="customer" />
	            </form:select>
				</div>
				 
				<input type="submit" name="submit" value="submit"
					class="btn-success btn" />
					
					
				
				</form:form>
				
				<c:if test="${not empty registerError }">
				<div class="alert alert-danger">${registerError}</div>
			</c:if>
			</div>
			</div>

	Register Status: ${registerError}


</body>
</html>