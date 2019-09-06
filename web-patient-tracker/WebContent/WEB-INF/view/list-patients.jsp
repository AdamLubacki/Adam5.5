<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Patients</title>
<link 	type="text/css" 
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>Patient list</h2>
	</div>
</div>
<div id="container">
	<div id="content">
	<input type="button" value="Add Patient "
			onclick="window.location.href='http://localhost:8081/web-patient-tracker/patient/showFormAdd';return false;"
			class="add-button"
	/>
	<table>
		<th> id </th>
		<th> First Name </th>
		<th> Last Name </th>
		<th> email </th>
		<c:forEach var="tempPatient" items="${patients}">
			<tr>
				<td>${tempPatient.id}</td>
				<td>${tempPatient.firstName}</td>
				<td>${tempPatient.lastName}</td>
				<td>${tempPatient.email}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>

</body>
</html>