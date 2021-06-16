<%@page contentType="text/html;charset=UTF-8" language="java" %>
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
      <form action="viewCars" method="get">
         <input type="submit" value="View Cars"/>
      </form> 
      <br>
      <form action="myBookings">
         <input type="submit" value="MyBookings"/>
      </form> 
</div>
</body>  
</html>