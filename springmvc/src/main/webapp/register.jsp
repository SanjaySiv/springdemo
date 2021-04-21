<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="center"> 
<h1>Register</h1>
<form action="save" method="post"> 
<div class="txt-field"> 
<input type="text" name="id" required/> 
<span></span>
<label> Id </label>
</div>
<div class="txt-field"> 
<input type="text" name="fname" required/>
<span></span>  
<label> First Name</label>
</div> 
<div class="txt-field"> 
<input type="text" name="lname" required/> 
<span></span>
<label> Last Name </label>
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