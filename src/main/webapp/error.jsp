<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Page Not Found</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
   
<div class="d-flex justify-content-center align-items-center ">
    <div class="row">
        <div class="col-md-12"> 
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                    404 Not Found</h2>
                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
                </div>
                <div class="error-actions">
                    <a href="<%=request.getContextPath()%>/listPatients" class="btn btn-primary btn-lg">Go back Home</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>