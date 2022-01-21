<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html> 
<html>
<head>
            <title>Patient Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        </head>
<body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: darkgrey">
                    <div>
                        <a  class="navbar-brand"> Management</a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listPatients" class="nav-link">Patients</a></li>
                        <li><a href="<%=request.getContextPath()%>/ListMeds" class="nav-link">Meds</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Meds</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/addMed" class="btn btn-success">Add New Med</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="Med" items="${listMeds}">

                                <tr>
                                    <td>
                                        <c:out value="${Med.idMed}" />
                                    </td>
                                    <td>
                                        <c:out value="${Med.nameMed}" />
                                    </td>
                                    <td><a href="updateMed?idMed=<c:out value='${Med.idMed}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteMed?idMed=<c:out value='${Med.idMed}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </body>
        </html>