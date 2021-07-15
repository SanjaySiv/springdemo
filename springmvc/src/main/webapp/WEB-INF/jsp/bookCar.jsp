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
.about-area, .service-area, .contact-area{
	position:relative;
	display:flex;
	justify-content:space-around;
	align-items:center;
	flex-wrap:wrap;
	flex-direction:row;
	width:100%;
	height:700px;
}
.text-part{
	width:65%;
	height:70%;
}
h1{
	font-size:50px;
	font-family:Audiowide;
	color:#ff8080;
}
p{
	font-size:20px;
	line-height:50px;
}
.about-area, .contact-area{
	background:#fefefe;
}
.service-area{
	background:#262626;
	color:#fff;
}
html{
	scroll-behavior:smooth;
}
.form_button{
	display:block;
	
	padding:.75rem 2rem;
	outline:none;
	border:none;
	background-color:#000;
	color:#fff;
	font-size:var(--normal-size);
	border-radius:.5rem;
	cursor:pointer;
	transition:.3s;
}
.form_button:hover{
	box-shadow:0 10px 36px rgba(0,0,0,.25);
}
.form_input{
	
	font-size:var(--normal-font-size);
	border: 1px solid var(--border-color);
	border-radius:.5rem;
	outline:none;
	padding:1rem;
	background:none;
	z-index:1;
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
<form action="confirmBooking" method="post">
	Car Id : ${carId}
	<input hidden="text" name="userId"  value="${userId}"/><br>
	<input hidden="text" name="carId"  value="${carId}"/><br>
	Booking Date : <input type="date" class="form_input" name="bookingDate" required/><br>
	Return Date : <input type="date" class="form_input"name="returningDate" required/><br>
	<input type="submit" class="form_button" value="confirm"/>
</form>
</div>
<jsp:include page="/WEB-INF/jsp/details.jsp"></jsp:include>
</body>
</html>