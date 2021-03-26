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
	Meals:
	Breakfast<form:checkbox path="food" value="Breakfast"/>
	Lunch<form:checkbox path="food" value="Lunch"/>
	Dinner<form:checkbox path="food" value="Dinner"/>
	<br><br>
	Leaving from : <form:select path="cityFrom">
		<form:option value="Ghaziabad" label="Ghaziabad"/>
		<form:option value="Modinagar" label="Modinagar"/>
		<form:option value="Meerut" label="Meerut"/>
		<form:option value="Amristar" label="Amristar"/>
	</form:select>
	<br><br>
	Going to : <form:select path="cityTo">
		<form:option value="Ghaziabad" label="Ghaziabad"/>
		<form:option value="Modinagar" label="Modinagar"/>
		<form:option value="Meerut" label="Meerut"/>
		<form:option value="Amristar" label="Amristar"/>
	</form:select>
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>