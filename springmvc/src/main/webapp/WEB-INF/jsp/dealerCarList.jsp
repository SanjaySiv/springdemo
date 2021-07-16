<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cars List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Car Id</th><th>Model</th><th>Seat No.</th><th>Registration No</th><th>Permit</th><th>Rent/Day</th><th>Location</th><th>Change Rent</th><th></th></tr>  
   <c:forEach var="cars" items="${dealerCarList}">   
   <tr>  
   <td><c:out value="${cars.carId}"/></td>  
   <td><c:out value="${cars.model}"/></td>  
   <td><c:out value="${cars.seat}"/></td>
   <td><c:out value="${cars.regNo}"/></td>
   <td><c:out value="${cars.permit}"/></td>  
   <td><c:out value="${cars.rent}"/></td>
   <td><c:out value="${cars.location}"/></td>
   <td>
   <form action="dealerChangeRent/${cars.carId}">
   <input hidden="text" name="dealerId"  value="${dealerId}"/>
   <input type="text" name="rent" size="5" required/>
   <input type="submit" value="Change"/>
   </form>
   </td>
   <td><a href="dealerDeleteCar/${cars.carId}/${dealerId}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <br>
      <form action="dealerAddCar" method="post">
      <input hidden="text" name="dealerId"  value="${dealerId}"/>
         <input type="submit" value="Add Car"/>
      </form>
</body>
</html>