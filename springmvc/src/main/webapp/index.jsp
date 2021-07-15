<!DOCTYPE html>
<html lang="en"> 
<head>
<meta charset="utf-8">
<title>Login form</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head> 
<body>
<jsp:include page="/WEB-INF/jsp/indRegNav.jsp"></jsp:include>
<div class="banner-area" id="home">
<div class="form">
	<form action="login" class="login" method="post"> 
	<h1 class="form_title">Sign In</h1>
		<div class="form_div"> 
			<input type="text" class="form_input" name="username" placeholder="" required/>  
			<label for="" class="form_label">User Name</label>
		</div> 
		<div class="form_div"> 
			<input type="password" class="form_input" name="password" placeholder="" required/> 
			<label for="" class="form_label"> Password </label>
		</div>
		<input type="submit" class="form_button" value="Sign In">
	</form>
	<form action="customerRegister">
		<input type="submit" class="form_button" value="Sign Up">
	</form>
</div>
<div class="covid">
	<form action="covid">
	<input type="submit" class="form_button" value="Covid Report India">
</form><br><br>
<form action="dealerRegister">
		<input type="submit" class="form_button" value="Register as Dealer">
	</form>
</div>
</div>
<jsp:include page="/WEB-INF/jsp/details.jsp"></jsp:include>
</body>  
</html>