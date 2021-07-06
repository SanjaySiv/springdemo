<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="eng" dir="ltr">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<style type="text/css">
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
th,td {
	padding: 15px;
    text-align: center;
}
th{
	color:white;
	background-color:black;
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
<div class="table">
<table border="2" width="70%" cellpadding="2">  
<tr><th>Car Id</th><th>Booking Date</th><th>Return Date</th><th>Rent Amount</th></tr>
   <tr>  
   <td>${details.carId}</td>  
   <td>${details.bookingDate}</td>  
   <td>${details.returnDate}</td>
   <td>${details.rentAmount}</td>
   </tr>
  </table>
 </div>
You have successfully booked your car. <a href="view" >back to home</a>
</body>
</html>