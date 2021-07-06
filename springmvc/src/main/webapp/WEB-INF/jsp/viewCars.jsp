<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>  
<html lang="eng" dir="ltr">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/viewCars.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="center">
<h1>Cars List</h1><br>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Car Id</th><th>Model</th><th>Seat No.</th><th>Permit</th><th>Rent/Day</th><th></th></tr>  
   <c:forEach var="cars" items="${list}">   
   <tr>  
   <td><c:out value="${cars.carId}"/></td>  
   <td><c:out value="${cars.model}"/></td>  
   <td><c:out value="${cars.seat}"/></td>  
   <td><c:out value="${cars.permit}"/></td> 
   <td><c:out value="${cars.rent}"/></td> 
   <td><a href="bookCar/${cars.carId}">Book</a></td>    
   </tr>  
   </c:forEach>  
   </table>
  </div>    
</body>
</html>