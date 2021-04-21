<!DOCTYPE html>
<html lang="en" dir="ltr"> 
<head>
<meta charset="utf-8">
<title>Login form</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head> 
<body> 
<div class="center"> 
<h1>Login</h1>
<form action="hello" method="post"> 
<div class="txt-field"> 
<input type="text" name="name" required/>
<span></span>  
<label> UserName</label>
</div> 
 <div class="txt-field"> 
<input type="password" name="pass" required/> 
<span></span>
<label> Password </label>
</div>
<input type="submit" value="Login">
<div class="signup_link">
Not a member? <a href="register.jsp">Register</a>
</div>
</form>
</div>
</body>  
</html>