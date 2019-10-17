<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<div class="col-sm-12 my-auto">
		<div class="col-sm-12 my-auto">
			<h1 class="my-lg-4" align='center'>ACTORS</h1>
			<p>
				<a class="btn btn-outline-dark btn-block"
					href='<c:url value="/create" />'>Create new</a>
			</p>
			<table class="table table-condensed" border="3">
				<tr>
					<th>Name</th>
					<th>Last name</th>
					<th>Gender</th>
				</tr>
				<c:forEach var="actor" items="${actors}">
					<tr>
						<td class="align-middle">${actor.getFirstname()}</td>
						<td class="align-middle">${actor.lastname}</td>
						<td class="align-middle">${actor.gender}</td>
						<td><a class="btn btn-outline-dark btn-lg"
							href='<c:url value="/edit?id=${actor.id}" />'>Edit</a> |
							<form method="post" action='<c:url value="/delete" />'
								style="display: inline;">
								<input class="btn btn-outline-dark btn-lg" type="hidden"
									name="id" value="${actor.id}"> <input
									class="btn btn-outline-dark btn-lg" onclick="return confirm('Do you want to delete?')" type="submit"
									value="Delete">
							</form></td>
					</tr>
				</c:forEach>
			</table>
			
	<!-- 		<h1 class="my-lg-4" align='center'>EVENTS</h1>
			<p>
				<a class="btn btn-outline-dark btn-block"
					href='<c:url value="/create" />'>Create new</a>
			</p>
			<table class="table table-condensed" border="3">
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>About</th>
				</tr>
				<c:forEach var="actor" items="${events}">
					<tr>
						<td class="align-middle">${event.getTitle_event()}</td>
						<td class="align-middle">${event.getComment_about_event()}</td>
						<td class="align-middle">${event.getPerformance_date()}</td>
						<td><a class="btn btn-outline-dark btn-lg"
							href='<c:url value="/edit?id=${event.id}" />'>Edit</a> |
							<form method="post" action='<c:url value="/delete" />'
								style="display: inline;">
								<input class="btn btn-outline-dark btn-lg" type="hidden"
									name="id" value="${event.id}"> <input
									class="btn btn-outline-dark btn-lg" onclick="return confirm('Do you want to delete?')" type="submit"
									value="Delete">
							</form></td>
					</tr>
				</c:forEach>
			</table>
			 -->
			
		</div>
	</div>
</body>
</html>