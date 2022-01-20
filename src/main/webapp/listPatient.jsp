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
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: red">
                    <div>
                        <a  class="navbar-brand"> Management</a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Patients</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Patients</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/add" class="btn btn-success">Add New Patient</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Country</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="Patient" items="${listPatients}">

                                <tr>
                                    <td>
                                        <c:out value="${Patient.idPatient}" />
                                    </td>
                                    <td>
                                        <c:out value="${Patient.namePatient}" />
                                    </td>
                                    <td>
                                        <c:out value="${Patient.emailPatient}" />
                                    </td>
                                    <td>
                                        <c:out value="${Patient.countryPatient}" />
                                    </td>
                                    <td><a href="update?idPatient=<c:out value='${Patient.idPatient}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?idPatient=<c:out value='${Patient.idPatient}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </body>
        </html>