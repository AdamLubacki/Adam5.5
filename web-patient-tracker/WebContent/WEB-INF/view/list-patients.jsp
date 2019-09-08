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
		<th> Action </th>
		<c:forEach var="tempPatient" items="${patients}">
			
			<c:url var="updateLink" value="/patient/showFormForUpdate">
				<c:param name="patientId" value="${tempPatient.id }"/>
			</c:url>
			<c:url var="deleteLink" value="/patient/deletePatient">
				<c:param name="patientId" value="${tempPatient.id }"/>
			</c:url>
			
			<tr>
				<td>${tempPatient.id}</td>
				<td>${tempPatient.firstName}</td>
				<td>${tempPatient.lastName}</td>
				<td>${tempPatient.email}</td>
				<td>
					<a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}"
						onclick="if (!(confirm('are you sure you want to delete this patient from list')))return false"
						>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>

</body>
</html>