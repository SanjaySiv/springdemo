<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>  
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/viewCars.css">
</head>
<body>
<h1>Customer List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Customer id</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th><th>Delete</th></tr>  
   <c:forEach var="users" items="${customerList}">   
   <tr>  
   <td><c:out value="${users.userId}"/></td> 
   <td><c:out value="${users.name}"/></td>  
   <td><c:out value="${users.address}"/></td>  
   <td><c:out value="${users.phone}"/></td>  
   <td><c:out value="${users.email}"/></td>  
   <td><a href="deleteCustomer/${users.userId}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table>  <br>
   <form action="addCustomer">
         <input type="submit" value="Add Customer"/>
      </form>
</body>
</html>