<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<%@ page import="java.util.*" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html>  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/viewCars.css">
</head>
<body>
<h1>Cars List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Model</th><th>Available</th><th>Seat No.</th><th>Permit</th><th>Edit</th></tr>  
   <c:forEach var="cars" items="${list}">   
   <tr>  
   <td><c:out value="${cars.model}"/></td>  
   <td><c:out value="${cars.available}"/></td>  
   <td><c:out value="${cars.seat}"/></td>  
   <td><c:out value="${cars.permit}"/></td>  
   <td><a href="book/${cars.model}">Book</a></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>