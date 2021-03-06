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
<h1>Booking List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Car Id</th><th>Booking Date</th><th>Return Date</th><th>Customer ID</th><th>Rent/Day</th></tr>  
   <c:forEach var="carDates" items="${bookingList}">   
   <tr>  
   <td><c:out value="${carDates.carId}"/></td>  
   <td><c:out value="${carDates.bookingDate}"/></td>  
   <td><c:out value="${carDates.returnDate}"/></td>  
   <td><c:out value="${carDates.customer_id}"/></td> 
   <td><c:out value="${carDates.rentAmount}"/></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>