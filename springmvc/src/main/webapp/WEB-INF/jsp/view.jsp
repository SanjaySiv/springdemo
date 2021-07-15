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
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
 
<div class="center">
	<div class="form">
	<p>${users.name}</p><br>
      <form action="viewCarList" method="post">
      <input hidden="text" name="userId" value="${users.userId}"/>
         <input type="submit" class="form_button" value="View Cars"/>
      </form> 
      <br>
      <form action="myBookings">
      <input hidden="text" name="userId" value="${users.userId}"/>
         <input type="submit" class="form_button" value="MyBookings"/>
      </form> 
      </div>
      <div class="images">
      	<img class="mySlides" src="../resources/images/car1.jpg" style="width:100%">
  		<img class="mySlides" src="../resources/images/car2.jpg" style="width:100%">
 	    <img class="mySlides" src="../resources/images/car3.jpg" style="width:100%">
      </div>
</div>
<jsp:include page="/WEB-INF/jsp/details.jsp"></jsp:include>
</body>  
</html>