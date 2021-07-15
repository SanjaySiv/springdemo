<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center">
${message}
<h1>Add Car</h1>
<form action="insertCar" method="post"> 
<div class="txt-field"> 
<input type="text" name="model" required/>
<span></span>  
<label> Model </label>
</div> 
<div class="txt-field"> 
<input type="text" name="seat" required/> 
<span></span>
<label> Seat </label>
</div>
<div class="txt-field"> 
<input type="text" name="regNo" required/> 
<span></span>
<label> Registration No </label>
</div>
 <div class="txt-field"> 
<input type="text" name="permit" required/> 
<span></span>
<label> Permit </label>
</div>
 <div class="txt-field"> 
<input type="text" name="rent" required/> 
<span></span>
<label> Rent/Day </label>
</div>
<div class="txt-field"> 
<input type="text" name="location" required/> 
<span></span>
<label> Location </label>
</div>
 <div class="txt-field"> 
<input type="text" name="dealerId" required/> 
<span></span>
<label> Dealer Id </label>
</div>
<input type="submit" value="Add">
</form>
</div>
</body>
</html>