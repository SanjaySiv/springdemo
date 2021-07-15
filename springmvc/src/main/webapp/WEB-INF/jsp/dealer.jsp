<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center">
      <form action="viewDealerCars" method="get">
      <input hidden="text" name="dealerId"  value="${users.userId}"/>
         <input type="submit" value="View Cars"/>
      </form> 
      <br>
      <form action="viewCustomers">
      <input hidden="text" name="userId"  value="${users.userId}"/>
         <input type="submit" value="View Customers"/>
      </form> 
      <br>
</div>
</body>
</html>