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
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<div class="center">
<h1>Cars List</h1><br> 
<table border="2" width="70%" cellpadding="2">  
<tr><th>Car Id</th><th>Model</th><th>Seat No.</th><th>Permit</th><th>Rent/Day</th><th></th></tr>  
   <c:forEach var="cars" items="${carList}">   
   <tr>  
   <td><c:out value="${cars.carId}"/></td>  
   <td><c:out value="${cars.model}"/></td>  
   <td><c:out value="${cars.seat}"/></td>  
   <td><c:out value="${cars.permit}"/></td> 
   <td><c:out value="${cars.rent}"/></td>
   <td><form action="bookCar/${cars.carId}" method="post">
    <input hidden="text" name="userId" value="${userId}"/>
   <input type="submit" value="Book"/> 
   </form></td> 
   </tr>  
   </c:forEach>  
   </table>
  </div>  
</body>
</html>