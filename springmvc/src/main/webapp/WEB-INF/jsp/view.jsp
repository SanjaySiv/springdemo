<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>  
<body>  
<p>${message}</p><br>
<form action="count">
         Enter sentence <br><br>
         <input type="text" name="sentence"/><br>
         <input type="submit" value="click"/>
      </form> 
</body>  
</html>