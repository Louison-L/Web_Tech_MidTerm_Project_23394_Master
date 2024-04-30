<%@page import="java.util.List"%>
<%@page import="dao.SemesterDao"%>
<%@page import="model.Semester"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Semesters</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
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
    SemesterDao semService = new SemesterDao();
    List<Semester> semesters = semService.getAllSemesters();
    %>

    <div class="container">
    <jsp:include page="QuestionOne.jsp" />
        <h1 class="text-center mb-4">Semesters</h1>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Semester ID</th>
                        <th>Semester Name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Semester semester : semesters) { %>
                    <tr>
                        <td><%= semester.getSemId() %></td>
                        <td><%= semester.getSemName() %></td>
                        <td><%= semester.getStartDate() %></td>
                        <td><%= semester.getEndDate() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            
        </div>
                <div class="form-group text-center">
                <button type="submit" class="btn btn-primary px-5" > <a href="registerSemester.jsp" style="text-decoration: none; color: inherit;">Previous Page</a></button>
                </div>

        <!-- <div class="d-flex">
            <a href="semCourse.jsp" class="btn btn-success m-auto">Add Courses</a>
        </div> -->
        

    
</body>
</html>