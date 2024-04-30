<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>

<%@page import="model.Semester"%>
<%@page import="model.Student"%>
<%@page import="model.StudentRegistration"%>
<%@page import="dao.StudentDao"%>
<%@page import="dao.SemesterDao"%>
<%@page import="dao.StudentRegistrationDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 900px;
            margin-top: 50px;
        }
        .card {
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
        }
    </style>
</head>
<body>
    <%
    StudentDao studentService = new StudentDao();
    List<Student> students = studentService.getAllStudents();

    SemesterDao semesterService = new SemesterDao();
    List<Semester> semesters = semesterService.getAllSemesters();
    %>

    <div class="container">
        <div class="card p-4">
            <h1 class="text-center mb-4">Create Student Registration</h1>
            <form id="registrationForm" method="POST" action="studentRegistration">
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="id" class="form-label">Registration Id</label>
                        <input type="text" class="form-control" name="id" id="id">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="regDate" class="form-label">Registration Date</label>
                        <input type="date" class="form-control" id="regDate" name="regDate">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="student" class="form-label">Choose Student</label>
                        <select name="student" id="student" class="form-select">
                            <option value="none">-- Select Student --</option>
                            <% for (Student student : students) { %>
                            <option value="<%= student.getRegNo() %>"><%= student.getName() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="semester" class="form-label">Choose Semester</label>
                        <select name="semester" id="semester" class="form-select">
                            <option value="none">-- Select Semester --</option>
                            <% for (Semester semester : semesters) { %>
                            <option value="<%= semester.getSemId() %>"><%= semester.getSemName() %></option>
                            <% } %>
                        </select>
                    </div>
                </div>
<!--                 <div class="text-center">
                    <button type="submit" class="btn btn-primary">Create Registration</button>
                    <button type="submit" class="btn btn-primary">Delete Registration</button>
                    <button type="submit" class="btn btn-primary">Update Registration</button>
                </div> -->
                
                <div class="form-group text-center">
                        <!-- <button type="submit" class="btn btn-primary px-5">Register a Teacher</button>
                        <button type="submit" class="btn btn-primary px-5">Update Teacher Info</button>
                        <button type="submit" class="btn btn-primary px-5" formaction="deleteUnit">Delete Teacher</button> -->
                        
                        <!-- <button type="button" onclick="window.location.href='displayAcademic.jsp';" class="btn btn-primary px-5">Display Unit</button> -->
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="insert">Save Student Registration</button>
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="update">Update Student Registration</button>
                        <!-- <button type="submit" class="btn btn-primary px-5" formaction="deleteUnit">Delete Unit</button> -->
                        <div class="form-group text-center mt-3">
                        <button type="submit" class="btn btn-primary" name="action" value="delete">Delete Student Registration</button>
                    </div>
                        
                    </div>
            </form>
            <div class="form-group text-center mt-3">
                    <a href="displayStudentRegistration.jsp" class="btn btn-primary px-5">Display Registration Infos</a>
                </div>
        </div>
    </div>

    <%
    if ("POST".equals(request.getMethod())) {
        String regId = request.getParameter("id");
        String regDate = request.getParameter("regDate");
        LocalDate date = LocalDate.parse(regDate);
        String studentCode = request.getParameter("student");
        String semCode = request.getParameter("semester");

        Student theStudent = studentService.findById(studentCode);
        Semester theSemester = semesterService.findById(semCode);

        StudentRegistration registration = new StudentRegistration();
        registration.setRegId(regId);
        registration.setRegDate(date);
        registration.setSemester(theSemester);
        registration.setStudent(theStudent);

        StudentRegistrationDao regService = new StudentRegistrationDao();
        regService.registerStudentRegistration(registration);
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
        	regService.registerStudentRegistration(registration);
        	
        } else if ("update".equals(action)) {
            // Add code to update student information
        } else if ("delete".equals(action)) {
            // Add code to delete student records
        }
        
        
        /* response.sendRedirect("displayStudentRegistration.jsp"); */
    }

    
    
    %>
</body>
</html>