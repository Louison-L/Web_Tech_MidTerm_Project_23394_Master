<%@page import="dao.StudentCourseDao"%>
<%@page import="model.StudentCourse"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>

<%@page import="model.Course"%>
<%@page import="model.Student"%>
<%@page import="model.StudentRegistration"%>
<%@page import="dao.StudentDao"%>
<%@page import="dao.CourseDao"%>
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

    CourseDao courseService = new CourseDao();
    List<Course> courses = courseService.getAllCourses();
    %>

    <div class="container">
        <div class="card p-4">
            <h1 class="text-center mb-4">Create Student Course</h1>
            <form id="registrationForm" method="POST" action="studentCourse">
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="id" class="form-label">Marks for the course</label>
                        <input type="text" class="form-control" name="id" id="id">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="course" class="form-label">Choose Course</label>
                        <select name="course" id="course" class="form-select">
                            <option value="none">-- Select Course --</option>
                            <% for (Course course : courses) { %>
                            <option value="<%= course.getCourseCode() %>"><%= course.getCourseName() %></option>
                            <% } %>
                        </select>
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
                    
                </div>
                <div class="col-md-4 mb-3">
                        <label for="id" class="form-label">Record ID</label>
                        <input type="text" class="form-control" name="Recordid" id="id">
                    </div>
               <!--  <div class="text-center">
                    <button type="submit" class="btn btn-primary">Create Student Registration</button>
                    <button type="submit" class="btn btn-primary">Delete Student Registration</button>
                    <button type="submit" class="btn btn-primary">Update Student Registration</button>
                </div> -->
                <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="insert">Insert a new Student Registration</button>
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="update">Update Student Registration</button>
                    </div>
                    <div class="form-group text-center mt-3">
                        <button type="submit" class="btn btn-primary" name="action" value="delete">Delete Student Registration</button>
                    </div>
            </form>
            <div class="form-group text-center mt-3">
                    <a href="displayStudentCourse.jsp" class="btn btn-primary px-5">Display Registration Infos</a>
                </div>
        </div>
    </div>

    <%
    if ("POST".equals(request.getMethod())) {
        String results = request.getParameter("id");
        String change = request.getParameter("Recordid");
        
        String studentCode = request.getParameter("student");
        String courseCode = request.getParameter("course");

        Student theStudent = studentService.findById(studentCode);
        Course theCourse = courseService.findById(courseCode);

        StudentCourse studentCourse = new StudentCourse();
        double marks = Double.parseDouble(results);
        studentCourse.setResults(marks);
        
        
        studentCourse.setCourse(theCourse);
        studentCourse.setStudent(theStudent);

        StudentCourseDao regStudentCourse = new StudentCourseDao();
        
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
        	regStudentCourse.registerStudent(studentCourse);
        } else if ("update".equals(action)) {
            // Add code to update student information
        } else if ("delete".equals(action)) {
            // Add code to delete student records
        }

        response.sendRedirect("displayStudentCourse.jsp");
    }
    %>
</body>
</html>