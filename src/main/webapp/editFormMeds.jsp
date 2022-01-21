<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand"> Management</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Patients</a></li>
				<li><a href="<%=request.getContextPath()%>/ListMeds" class="nav-link">Meds</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="updateMed" method="post">
					<h2>Edit Med</h2>
					<fieldset class="form-group">
					<label>Med Id</label>
					 <input type="text" name="idMed" value="${param.idMed}" readonly/>
					 </fieldset>
					<fieldset class="form-group">
						<label>Med Name</label> 
						<input type="text"	class="form-control"  name="nameMed" >
					</fieldset>


					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>