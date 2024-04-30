<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="dao.StudentCourseDao"%>
<%@page import="model.StudentCourse"%>
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
    StudentCourseDao dao = new StudentCourseDao();
    List<StudentCourse> unit = dao.getAllStudentCourses();
    %>

    <div class="container">
    <jsp:include page="QuestionOne.jsp" />
        <h1 class="text-center mb-4">Student Course Form</h1>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                    
                        <th>Code</th>
                        <th> Student ID</th>
                        <th> Student Names</th>
                        <th>Course Name</th>
                        <th>Marks</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (StudentCourse academicUnit : unit) { %>
                    <tr>
                   		 <td><%= academicUnit.getId() %></td>
                   		 
                   		 <td><%= academicUnit.getStudent()!=null? academicUnit.getStudent().getRegNo():"" %></td>
                   		 <td><%= academicUnit.getStudent()!=null? academicUnit.getStudent().getName():"" %></td>
                        <%-- <td><%=  %></td> --%>
                        
                        
                        <td><%= academicUnit.getCourse()!=null? academicUnit.getCourse().getCourseName():"" %></td>
                        <td><%= academicUnit.getResults() %></td>
                        
                        
                       
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <div class="form-group text-center">
                <button type="submit" class="btn btn-primary px-5" > <a href="registerStudentCourse.jsp" style="text-decoration: none; color: inherit;">Previous Page</a></button>
                </div>
    </div>
</body>
</html>