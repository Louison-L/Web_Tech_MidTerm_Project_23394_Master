<%@page import="dao.SemesterDao"%>
<%@page import="model.Semester"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Semester</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .form-group label {
            font-weight: 500;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card shadow-sm">
            <div class="card-body">
                <h1 class="text-center mb-4">Create a Semester</h1>
                <form  id="academicUnitForm" method="POST" action="semester">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name">Semester Name</label>
                            <input type="text" class="form-control" name="name" id="name" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="code">Semester Id</label>
                            <input type="text" class="form-control" id="code" name="code" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="startDate">Semester Start Date</label>
                            <input type="date" class="form-control" id="startDate" name="startDate" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="endDate">Semester End Date</label>
                            <input type="date" class="form-control" id="endDate" name="endDate" required>
                        </div>
                    </div>
                    <!-- <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary px-5">Insert a New Semester</button>
                        <button type="submit" class="btn btn-primary mr-2">Update Semester Info</button>
                    </div>
                                         <div class="form-group text-center mt-3">
                     <button type="submit" class="btn btn-primary" formaction="">Delete a Semester Record</button>
                    <a href="displayStudents.jsp" class="btn btn-primary px-5">Display Students</a>
                </div> -->
                <div class="form-group text-center">
                        <!-- <button type="submit" class="btn btn-primary px-5">Register a Teacher</button>
                        <button type="submit" class="btn btn-primary px-5">Update Teacher Info</button>
                        <button type="submit" class="btn btn-primary px-5" formaction="deleteUnit">Delete Teacher</button> -->
                        
                        <!-- <button type="button" onclick="window.location.href='displayAcademic.jsp';" class="btn btn-primary px-5">Display Unit</button> -->
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="insert">Save Semester</button>
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="update">Update Semester Records</button>
                        <!-- <button type="submit" class="btn btn-primary px-5" formaction="deleteUnit">Delete Unit</button> -->
                        <div class="form-group text-center mt-3">
                        <button type="submit" class="btn btn-primary" name="action" value="delete">Delete Semester Records</button>
                    </div>
                        
                    </div>
                </form>
                <div class="form-group text-center mt-3">
                    <a href="displaySemester.jsp" class="btn btn-primary px-5">Display Semesters Records</a>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

    <%
    if("POST".equals(request.getMethod())){
        String semName = request.getParameter("name");
        String semId = request.getParameter("code");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        Semester semester = new Semester();
        semester.setSemName(semName);
        semester.setSemId(semId);
        semester.setStartDate(startDate);
        semester.setEndDate(endDate);
        SemesterDao semesterService = new SemesterDao();
        
        response.sendRedirect("displaySemester.jsp");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
        	semesterService.registerSemester(semester);
        	
        } else if ("update".equals(action)) {
            // Add code to update student information
        } else if ("delete".equals(action)) {
            // Add code to delete student records
        }
    }
    %>
