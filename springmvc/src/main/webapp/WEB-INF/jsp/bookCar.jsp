<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
body{
	margin:0;
	padding:0;
	font-family:Poppins;
	font-size:var(--normal-font-size);
}
.navbar{
	position:fixed;
	display:flex;
	justify-content:center;
	align-items:center;
	flex-direction:row;
	flex-wrap:wrap;
	background-color:#fff;
	width:100%;
	height:70px;
	z-index:1;
}
.nav{
	display:flex;
	justify-content:right;
	list-style:none;
	margine-right:15%;
}
.logo{
	flex:1 1 auto;
	margin-left:10%;
	text-transform:uppercase;
	letter-spacing:1px;
	font-weight:bold;
	font-size:35px;
}
a{
	margin:15px;
	color:#000;
	text-decoration:none;
	text-transform:uppercase;
}
a:hover{
	color:#ff8080;
}
.center{
	padding:100px;
}
</style>
</head>
<body>
<div class="navbar"> 
<a href="#" class="logo">Logo</a>
<ul class="nav">
<li><a href="view.jsp">Home</a></li>
<li><a href="#about">About</a></li>
<li><a href="#service">Service</a></li>
<li><a href="#contact">Contact</a></li>
<li><a href="index.jsp">Sign Out</a></li>
</ul>
</div>
<div class=center>
<form action="confirmBooking">
	Car Id : ${carId}
	<input hidden="text" name="carId"  value="${carId}"/><br>
	Booking Date : <input type="date" class="form_input" name="bookingDate" required/><br>
	Return Date : <input type="date" class="form_input"name="returningDate" required/><br>
	<input type="submit" value="confirm"/>
</form>
</div>
</body>
</html>