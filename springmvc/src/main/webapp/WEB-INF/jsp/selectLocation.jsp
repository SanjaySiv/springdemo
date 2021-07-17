<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.location{
	float:left;
	padding:150px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<div class="location">
<form action="viewCarList" method="post">
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
</div>
<jsp:include page="/WEB-INF/jsp/details.jsp"></jsp:include>
</body>
</html>