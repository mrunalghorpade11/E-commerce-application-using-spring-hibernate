<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/resources/static/head.jsp"%>
<title>Supplier View</title>
<%@ include file="/resources/static/Navbar.jsp"%>
</head>
<body>

<div class="container">
</div>

<div class="col-md-4 col-md-offset-4 col-xs-12 col-lg-4 col-lg-offset-4 col-sm-12 well well-sm">

<form action="supplierAction.htm" method="GET">
	<div class="form-group">

		<label>Choose you preffered Action</label>
		<select name = "actionParam">
			<option value = "add">Add products</option>
			<option value = "view">View Products</option>
		</select>
		<br>
		<input type="submit" value = "Submit">



	</div>
</form>


</div>

</body>
</html>