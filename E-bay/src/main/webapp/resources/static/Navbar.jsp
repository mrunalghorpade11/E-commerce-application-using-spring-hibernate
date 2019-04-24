<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
			<a class="navbar-brand" href="#">E-Bay</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath }">Home</a></li>
      </ul>
      		<ul class="nav navbar-nav navbar-right">
		<c:choose>
			<c:when test="${sessionScope.customer == null}">
			
				<li><a href="${contextPath}/register.htm"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${contextPath}/login.htm"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			

			</c:when>
			
			<c:otherwise>
			
				<li><a href="${contextPath}/logout.htm"><span
						class="glyphicon glyphicon-log-in"></span> Signout</a></li>
			
			</c:otherwise>
			
		</c:choose>
		</ul>
    </div>
		
		

	</div>
</nav>


<br>

