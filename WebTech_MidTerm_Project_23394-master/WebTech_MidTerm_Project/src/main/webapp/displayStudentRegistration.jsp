<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="dao.StudentRegistrationDao"%>
<%@page import="model.StudentRegistration"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Academic Units</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 900px;
            margin-top: 50px;
        }
        .table {
            background-color: #ffffff;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
        }
    </style>
</head>
<body>
    <%
    StudentRegistrationDao dao = new StudentRegistrationDao();
    List<StudentRegistration> registrations = dao.getAllStudentRegistration();
    %>

    <div class="container">
    <jsp:include page="QuestionOne.jsp" />
        <h1 class="text-center mb-4">Student Registration Form</h1>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                    
                        <th>Student Registration ID</th>
                        <th> Registration Date</th>
                        <th>Semester Name</th>
                        <th>Student Name</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (StudentRegistration registration : registrations) { %>
                    <tr>
                   		 <td><%= registration.getRegId() %></td>
                        <td><%= registration.getRegDate() %></td>
                       <%--  <td><%= registration.getSemester().getSemName() %></td>
                        <td><%= registration.getStudent().getName() %></td> --%>
                        
                        
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <div class="form-group text-center">
                <button type="submit" class="btn btn-primary px-5" > <a href="registerStudentRegistration.jsp" style="text-decoration: none; color: inherit;">Previous Page</a></button>
                </div>
    </div>
</body>
</html>