<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beautiful Design</title>
<style>
    body {
        background-color: #f5f5f5;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .btn {
        display: inline-block;
        padding: 12px 24px;
        font-size: 16px;
        font-weight: bold;
        text-decoration: none;
        color: #ffffff;
        background-color: #2196F3; /* Changed to blue */
        border-radius: 4px;
        transition: background-color 0.3s ease;
        margin: 4px;
    }

    .btn:hover {
        background-color: #1976D2; /* Changed to darker blue on hover */
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome to our Main Page</h1>
        <p>Click on any of the buttons below to explore:</p>
        <a href="displayAcademic.jsp" class="btn">Display Academics Units Details</a>
        <a href="displayCourses.jsp" class="btn">Display Courses Details</a>
        <a href="displaySemester.jsp" class="btn">Display Semesters Details</a>
        <a href="displayStudentRegistration.jsp" class="btn">Display Students Registrations</a>
        <a href="displayStudents.jsp" class="btn">Display Students</a>
        <a href="displayTeacher.jsp" class="btn">Display Teachers</a>
        <a href="displayStudentCourse.jsp" class="btn">Display Students Course</a>
    </div>
</body>
</html>