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
<h1>Admin List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Customer id</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th><th>Delete</th></tr>  
   <c:forEach var="customer" items="${adminList}">   
   <tr>  
   <td><c:out value="${customer.customer_id}"/></td> 
   <td><c:out value="${customer.name}"/></td>  
   <td><c:out value="${customer.address}"/></td>  
   <td><c:out value="${customer.phone}"/></td>  
   <td><c:out value="${customer.email}"/></td>  
   <td><a href="deleteCustomer/${customer.customer_id}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table> 
   <br>
<form action="addAdmin">
         <input type="submit" value="Add Admin"/>
      </form>
</body>
</html>