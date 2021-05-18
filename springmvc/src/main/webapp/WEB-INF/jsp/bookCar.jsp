<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="confirmBooking">
	Car Id : ${carId} <br>
	<input hidden="text" name="carId" value="${carId}"/><br>
	Booking Date : <input type="date" name="bookingDate" required/><br>
	Return Date : <input type="date" name="returningDate" required/><br>
	<input type="submit" value="confirm"/>
</form>
</body>
</html>