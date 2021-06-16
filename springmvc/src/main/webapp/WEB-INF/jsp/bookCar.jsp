<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div class=center>
<form action="confirmBooking">
	Car Id : ${carId}
	<input hidden="text" name="carId" value="${carId}"/><br>
	Booking Date : <input type="date" name="bookingDate" required/><br>
	Return Date : <input type="date" name="returningDate" required/><br>
	<input type="submit" value="confirm"/>
</form>
</div>
</body>
</html>