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
<h2>Latest Updates of Covid cases in India</h2>
Active Cases : ${covid.activeCases}<br>
Active Cases New : ${covid.activeCasesNew}<br>
Recovered : ${covid.recovered}<br>
RecoveredNew : ${covid.recoveredNew}<br>
Deaths : ${covid.deaths}<br>
Deaths New : ${covid.deathsNew}<br>
Previous Day Tests : ${covid.previousDayTests}<br>
Total Cases : ${covid.totalCases}<br>
<h3>Region wise updates :-</h3>
	  <c:forEach items="${covid.regionData}" var="regionData">
		 <h3><c:out value="${regionData.region}" /><br></h3>
         Active Cases : <c:out value="${regionData.activeCases}" /><br>
         New Infected : <c:out value="${regionData.newInfected}" /><br>
         Recovered : <c:out value="${regionData.recovered}" /><br>
         New Recovered : <c:out value="${regionData.newRecovered}" /><br>
         Deceased : <c:out value="${regionData.deceased}" /><br>
         NewDeceased : <c:out value="${regionData.newDeceased}" /><br>
         Total Infected : <c:out value="${regionData.totalInfected}" /><br><br>
      </c:forEach>
</body>
</html>