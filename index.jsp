<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://bootswatch.com/4/cyborg/bootstrap.css" media="screen">
<link rel="stylesheet"
	href="https://bootswatch.com/_assets/css/custom.min.css">

<title>Get Your Weather !</title>
</head>

<body>
	<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<div class="container">
			<a href="../" class="navbar-brand"><h2>Get Your Weather !</h2></a>

		</div>
	</div>
<br>
<br>

	<div class="row" >
		<div class="col-lg-6 offset-lg-3">
			<div class="bs-component">
				<form action="${pageContext.request.contextPath}/DataFetching"
		method="post" >
					<fieldset>
						<div class="form-group" >
						
						
							<h4>City :</h4><input type="text"
								class="form-control" id="WeatherCity"
								aria-describedby="emailHelp" placeholder="Enter city" name="location" > <small
								id="WeatherCity" class="form-text text-muted">Enter City
								name for which you want to search Weather.</small>
								
								<br>
								
								<button type="submit" class="btn btn-primary">Get Weather</button>
						</div>
					</fieldset>
					Weather in 
					<% out.print(request.getParameter("location")); %>
					is 
					
					<%
		                    String temp = (String) request.getAttribute("Temperature");
		                       out.print(temp);
	                %> 
	                &deg; Celsius
				</form>
			</div>
		</div>
	</div>

	

</body>
</html>