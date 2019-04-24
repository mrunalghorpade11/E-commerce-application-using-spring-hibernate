<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/resources/static/head.jsp"%>
<title>Login File</title>
</head>
<body>
<%@ include file="/resources/static/Navbar.jsp"%>

<div class="container">
</div>

<div class="col-md-4 col-md-offset-4 col-xs-12 col-lg-4 col-lg-offset-4 col-sm-12 well well-sm">
			
	<form:form action="login.htm" method="POST" commandName="Customer" modelAttribute="customer">
				<div class="form-group">
				
				<label for="username">User Name:</label>

					<form:input path="userName" name="userName" class="form-control" />
					<strong> <form:errors path="userName" />
					</strong>
				</div>
				
				<div class="form-group">
					<label for="password">Password</label>
					<form:input path="password" name="password" type="password" class="form-control" />
					<strong> <form:errors path="password" />
					</strong>
				</div>
				<div class = "form-group">
				<label>Role</label>
				<form:select path="role">
		            <form:option value="supplier" label="supplier" />
		            <form:option value="customer" label="customer" />
	            </form:select>
				</div>
				
				<input type="submit" name="submit" value="Login"
					class="btn btn-success" />

				<br>
				
	</form:form>	
		
			
</div>

<!--
<form action = "/category" method = "post">
User Name : <input type = "text" name = "userName"><br/>
Password : <input type = "text" name="password"></br>
<input type="submit"/>
</form>  -->

</body>
</html>