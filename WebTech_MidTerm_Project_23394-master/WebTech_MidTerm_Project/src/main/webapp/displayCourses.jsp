<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AUCA Students</title>
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
        /* Custom styling for Course Description column */
        th.description-column {
            width: 40%; /* Adjust this value as needed */
        }
    </style>
</head>
<body>
    <% 
    CourseDao courseService = new CourseDao();
    List<Course> courses = courseService.getAllCourses();
    %>

    <div class="container">
    <jsp:include page="QuestionOne.jsp" />
        <h1 class="text-center mb-4">AUCA Courses</h1>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Course Name</th>
                        <th>Course Code</th>
                        <th class="description-column">Course Description</th>
                        <th>Department</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Course course : courses) { %>
                    <tr>
                        <td><%= course.getCourseName() %></td>
                        <td><%= course.getCourseCode() %></td>
                        <td><%= course.getDescription() %></td>
                        <td><%= course.getDepartment().getName() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <div class="form-group text-center">
            <button type="submit" class="btn btn-primary px-5">
                <a href="registerCourse.jsp" style="text-decoration: none; color: inherit;">Previous Page</a>
            </button>
        </div>
    </div>
</body>
</html>
