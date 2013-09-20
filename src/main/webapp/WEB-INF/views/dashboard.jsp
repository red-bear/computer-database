<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>EPF Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/main.css" rel="stylesheet" media="screen">
</head>
<body>

<jsp:include page="include/header.jsp" />

<section id="main">
	<h1 id="homeTitle"><c:out value="${computers_count}"/> Computers found</h1>
	<div id="actions">
		<form action="searchcomputers" method="GET">
			<input type="search" id="searchbox" name="search"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Search by name"
				class="btn primary">
		</form>
		<a class="btn success" id="add" href="addcomputer">Add Computer</a>
	</div>

	<table class="computers zebra-striped">
		<thead>
			<tr>
				<!-- Variable declarations for passing labels as parameters -->
				<!-- Table header for Computer Name -->
				<th>Computer Name</th>
				<th>Introduced Date</th>
				<!-- Table header for Discontinued Date -->
				<th>Discontinued Date</th>
				<!-- Table header for Company -->
				<th>Company</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${computers}" var="comp">  
				<tr>
					<td><a href="editcomputer?id=${comp.id}" onclick="">
					<c:out value="${comp.name}"/></a></td>
					<td><c:out value="${comp.introduced}"/></td>
					<td><c:out value="${comp.discontinued}"/></td>
					<td><c:out value="${comp.company.name}"/></td>
					<td><a href="deletecomputer?id=${comp.id}">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
</section>
<jsp:include page="include/footer.jsp" />
