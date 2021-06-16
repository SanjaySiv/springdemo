<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en" dir="ltr"> 
<head>
<meta charset="utf-8">
<title>Login form</title>
<link rel="stylesheet" type="text/css" href="css/view.css">
</head>  
<p>${message}</p><br> 
<div class="center">
      <form action="editCars" method="get">
         <input type="submit" value="View Cars"/>
      </form> 
      <br>
      <form action="viewCustomers">
         <input type="submit" value="View Customers"/>
      </form> 
      <br>
      <form action="viewBookings">
         <input type="submit" value="View Bookings"/>
      </form> 
</div>
</body>  
</html>