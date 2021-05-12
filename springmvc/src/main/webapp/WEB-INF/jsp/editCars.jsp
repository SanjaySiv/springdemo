<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/viewCars.css">
</head>
<body>
<a href="cars.jsp">Add Car</a> <br><br>
<h1>Cars List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Car Id</th><th>Model</th><th>Seat No.</th><th>Registration No</th><th>Permit</th><th>Delete</th></tr>  
   <c:forEach var="cars" items="${list}">   
   <tr>  
   <td><c:out value="${cars.carId}"/></td>  
   <td><c:out value="${cars.model}"/></td>  
   <td><c:out value="${cars.seat}"/></td>
   <td><c:out value="${cars.regNo}"/></td>
   <td><c:out value="${cars.permit}"/></td>  
   <td><a href="deleteCar/${cars.carId}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>