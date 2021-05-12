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
   <c:forEach var="customer" items="${list}">   
   <tr>  
   <td><c:out value="${customer.cid}"/></td> 
   <td><c:out value="${customer.name}"/></td>  
   <td><c:out value="${customer.address}"/></td>  
   <td><c:out value="${customer.phone}"/></td>  
   <td><c:out value="${customer.email}"/></td>  
   <td><a href="deleteCustomer/${customer.cid}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>