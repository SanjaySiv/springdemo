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
<h2>Updates of covid cases in India</h2>
activeCases : ${covid.activeCases}<br>
activeCasesNew : ${covid.activeCasesNew}<br>
recovered : ${covid.recovered}<br>
recoveredNew : ${covid.recoveredNew}<br>
deaths : ${covid.deaths}<br>
deathsNew : ${covid.deathsNew}<br>
previousDayTests : ${covid.previousDayTests}<br>
totalCases : ${covid.totalCases}<br>
<h3>Region wise updates :-</h3>
<c:forEach items="${covid.regionData}" var="regionData">
		 <h3><c:out value="${regionData.region}" /><br></h3>
         activeCases : <c:out value="${regionData.activeCases}" /><br>
         newInfected : <c:out value="${regionData.newInfected}" /><br>
         recovered : <c:out value="${regionData.recovered}" /><br>
         newRecovered : <c:out value="${regionData.newRecovered}" /><br>
         deceased : <c:out value="${regionData.deceased}" /><br>
         newDeceased : <c:out value="${regionData.newDeceased}" /><br>
         totalInfected : <c:out value="${regionData.totalInfected}" /><br><br>
      </c:forEach>
</body>
</html>