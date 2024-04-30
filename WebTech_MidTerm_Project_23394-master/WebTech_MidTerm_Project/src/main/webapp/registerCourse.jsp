<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatterBuilder"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
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
    <%
    AcademicUnitDao unitService = new AcademicUnitDao();
    List<AcademicUnit> units = unitService.findByUnitType("DEPARTMENT");
    %>

    <div class="container">
        <div class="card shadow-sm">
            <div class="card-body">
                <h1 class="text-center mb-4">Course Registration</h1>
                <form method="POST" action="courseService" id="academicUnitForm">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name">Course Name</label>
                            <input type="text" class="form-control" name="name" id="name" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="code">Course Code</label>
                            <input type="text" class="form-control" id="code" name="code" required>
                        </div>
                    </div>
                    <div class="form-row">
                        
                        <div class="form-group col-md-6">
    <label for="description">Course Description</label>
    <textarea class="form-control" id="description" name="description" required></textarea>
</div>
                        
                        
                        
                        <div class="form-group col-md-6">
                            <label>Department</label>
                            <select name="dept" class="form-control" id="unitType">
                                <option value="none">-- Select Department --</option>
                                <%for(AcademicUnit unit : units){ %>
                                <option value="<%= unit.getCode()%>"><%= unit.getName() %></option>
                                <%} %>
                            </select>
                        </div>
                    </div>
                    <!-- <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary mr-2">Insert a new Course</button>
                        <button type="submit" class="btn btn-primary mr-2">Update Course Info</button>
                        
                    </div>
                     <div class="form-group text-center mt-3">
                     <button type="submit" class="btn btn-primary" formaction="">Delete Course Records</button> -->
                    <!-- <a href="displayStudents.jsp" class="btn btn-primary px-5">Display Students</a> -->
                <!-- </div> -->
                <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="insert">Insert a new Course</button>
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="update">Update Course Info</button>
                    </div>
                    <div class="form-group text-center mt-3">
                        <button type="submit" class="btn btn-primary" name="action" value="delete">Delete Course Records</button>
                    </div>
                </form>
                <div class="form-group text-center mt-3">
                    <a href="displayCourses.jsp" class="btn btn-primary px-5">Display Courses</a>
                </div>
            </div>
        </div>
    </div>

    <%
    
    
    if("POST".equalsIgnoreCase(request.getMethod())){
    	CourseDao courseService = new CourseDao();
        Course theCourse = new Course();
        String courseName = request.getParameter("name");
        String courseCode = request.getParameter("code");
        String description = request.getParameter("description");
        
        String department = request.getParameter("dept");
        theCourse.setCourseCode(courseCode);
        theCourse.setCourseName(courseName);
        theCourse.setDescription(description);
        AcademicUnit unit = unitService.findById(department);
        theCourse.setDepartment(unit);
        
        /* studentService.registerStudent(student); */
         String action = request.getParameter("action");
        if ("insert".equals(action)) {
        	courseService.registerCourse(theCourse);
        } else if ("update".equals(action)) {
            // Add code to update student information
        } else if ("delete".equals(action)) {
            // Add code to delete student records
        }
        response.sendRedirect("displayStudents.jsp");
    }
    %>
</body>
</html>