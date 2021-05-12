<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div class="center"> 
<h1>Register</h1>
<form action="save" method="post"> 
<div class="txt-field"> 
<input type="text" name="name" required/> 
<span></span>
<label> Name </label>
</div>
<div class="txt-field"> 
<input type="text" name="address" required/>
<span></span>  
<label> Address </label>
</div> 
<div class="txt-field"> 
<input type="text" name="phone" required/> 
<span></span>
<label> Phone no </label>
</div>
<div class="txt-field"> 
<input type="text" name="email" required/> 
<span></span>
<label> Email </label>
</div>
 <div class="txt-field"> 
<input type="password" name="pass" required/> 
<span></span>
<label> Password </label>
</div>
<input type="submit" value="Register">
</form>
</div>

</body>
</html>