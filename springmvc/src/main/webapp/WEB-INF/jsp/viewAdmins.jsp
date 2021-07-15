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
<tr><th>Admin id</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th><th>Delete</th></tr>  
   <c:forEach var="users" items="${adminList}">   
   <tr>  
   <td><c:out value="${users.userId}"/></td> 
   <td><c:out value="${users.name}"/></td>  
   <td><c:out value="${users.address}"/></td>  
   <td><c:out value="${users.phone}"/></td>  
   <td><c:out value="${users.email}"/></td>  
   <td><a href="deleteAdmin/${users.userId}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table> 
   <br>
<form action="addAdmin">
         <input type="submit" value="Add Admin"/>
      </form>
</body>
</html>