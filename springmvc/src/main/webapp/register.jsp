<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/indRegNav.jsp"></jsp:include>
<div class="banner-area" id="home">
<div class="form">
	<form action="save" class="login" > 
	<h1 class="form_title">Register</h1>
		<div class="form_div"> 
			<input type="text" class="form_input" name="name" placeholder="" required/>  
			<label for="" class="form_label">Name</label>
		</div> 
		<div class="form_div"> 
			<input type="text" class="form_input" name="address" placeholder="" required/> 
			<label for="" class="form_label"> Address </label>
		</div>
		<div class="form_div"> 
			<input type="text" class="form_input" name="phone" placeholder="" required/> 
			<label for="" class="form_label"> Phone No </label>
		</div>
		<div class="form_div"> 
			<input type="text" class="form_input" name="email" placeholder="" required/> 
			<label for="" class="form_label"> Email </label>
		</div>
		<div class="form_div"> 
			<input type="text" class="form_input" name="username" placeholder="" required/> 
			<label for="" class="form_label"> User Name </label>
		</div>
		<div class="form_div"> 
			<input type="password" class="form_input" name="password" placeholder="" required/> 
			<label for="" class="form_label"> Password </label>
		</div>
		<input type="submit" class="form_button" value="Register">
	</form>
</div>
</div>
<jsp:include page="/WEB-INF/jsp/details.jsp"></jsp:include>
</body>
</html>