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

	<h1>
	<c:choose>
		<c:when test="${not empty computer}">Edit computer ${computer.name}</c:when>
		<c:otherwise>Add Computer</c:otherwise>
	</c:choose>
	</h1>
	
	<form action="addcomputerpost" method="POST">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
					<input type="text" name="name" />
					<span class="help-inline">Required</span>
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<input type="date" name="introducedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<input type="date" name="discontinuedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<select name="company">
						<c:forEach items="${companies}" var="company"> 
							<c:if test="${not empty company}">
							    <option value='<c:out value="${company.id}"/>'>
									<c:out value="${company.name}"/>
								</option>	
							</c:if>							
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<input type="submit" value="Add" class="btn primary">
			or <a href="dashboard" class="btn">Cancel</a>
		</div>
	</form>
</section>

<jsp:include page="include/footer.jsp" />