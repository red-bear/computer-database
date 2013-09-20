<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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

	<h1>Add Computer</h1>
	
	<sf:form method="POST" action="addcomputerpost" modelAttribute="computer">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
					<sf:input path="name" type="text"/>
					<span class="help-inline">Required</span>
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<sf:input type="date" path="introduced" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<sf:input type="date" path="discontinued" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<sf:select path="companyId">
						<sf:options items="${companies}" itemLabel="name" itemValue="id" />						
					</sf:select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<c:if test="${type == 1}">
			   <input type="submit" value="Add" class="btn primary">
			</c:if>
			<c:if test="${type == 2}">
			   <input type="submit" value="Update" class="btn primary">
			</c:if>
			or <a href="dashboard" class="btn">Cancel</a>
		</div>
	</sf:form>
</section>
<jsp:include page="include/footer.jsp" />