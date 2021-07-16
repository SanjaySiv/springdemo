<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="selectLocation">
<select  name="location">
  <c:forEach items="${locationList}" var="location"  >
    <option value="${location.location}" >
        ${location.location}
    </option>
  </c:forEach>
</select>
<input hidden="text" name="userId" value="${userId}"/>
<input type="submit" value="Show Cars"/>
</form>
</body>
</html>