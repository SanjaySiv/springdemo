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
<jsp:include page="/header.jsp"></jsp:include>
<h1>My Bookings</h1>
<div class="center"> 
<table border="2" width="70%" cellpadding="2">  
<tr><th>Booking Date</th><th>Return Date</th><th>Rent amount</th></tr>  
   <c:forEach var="carDate" items="${list}">   
   <tr>  
   <td><c:out value="${carDate.bookingDate}"/></td>  
   <td><c:out value="${carDate.returnDate}"/></td>  
   <td><c:out value="${carDate.rentAmount}"/></td>      
   </tr>  
   </c:forEach>  
   </table> 
</div>  
</body>
</html>