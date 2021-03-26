<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<title>Reservation Form</title>
</head>
<h3>Railway Reservation Form</h3> 
<body>
	<form:form action="submitForm" modelAttribute="reservation">
	FirstName <form:input path="firstName"/>
	<br><br>
	LastName <form:input path="lastName"/>
	<br><br>
	Gender:
	Male<form:radiobutton path="Gender" value="Male"/>
	Female<form:radiobutton path="Gender" value="Female"/>
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>