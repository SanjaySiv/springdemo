<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en" dir="ltr"> 
<head>
<meta charset="utf-8">
<title>Login form</title>
<link rel="stylesheet" type="text/css" href="css/view.css">
</head>
<body>  
<jsp:include page="/header.jsp"></jsp:include>
 
<div class="center">
	<div class="form">
	<p>${message}</p><br>
      <form action="viewCars" method="get">
         <input type="submit" class="form_button" value="View Cars"/>
      </form> 
      <br>
      <form action="myBookings">
         <input type="submit" class="form_button" value="MyBookings"/>
      </form> 
      </div>
      <div class="images">
      	<img class="mySlides" src="../resources/images/car1.jpg" style="width:100%">
  		<img class="mySlides" src="../resources/images/car2.jpg" style="width:100%">
 	    <img class="mySlides" src="../resources/images/car3.jpg" style="width:100%">
      </div>
</div>
</body>  
</html>