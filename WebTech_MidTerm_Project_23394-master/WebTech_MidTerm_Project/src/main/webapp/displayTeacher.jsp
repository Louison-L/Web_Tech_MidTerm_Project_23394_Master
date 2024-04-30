<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="dao.TeacherDao"%>
<%@page import="model.Teacher"%>
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
    TeacherDao dao = new TeacherDao();
    List<Teacher> unit = dao.getAllTeachers();
    %>

    <div class="container">
    <jsp:include page="QuestionOne.jsp" />
        <h1 class="text-center mb-4">AUCA Teachers</h1>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                    <th>Teacher Id</th>
                        <th>Teacher Name</th>
                        <th>Teacher Qualification</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <% for (Teacher academicUnit : unit) { %>
                    <tr>
                   		 <td><%= academicUnit.getCode() %></td>
                        <td><%= academicUnit.getName() %></td>
                        <td><%= academicUnit.getQualification() %></td>
                        <%-- <td><%= academicUnit.getProgram() != null ? academicUnit.getProgram().getName() : "" %></td>
                        <td><%= academicUnit.getFaculty() != null ? academicUnit.getFaculty().getName() : "" %></td> --%>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <div class="form-group text-center">
                <button type="submit" class="btn btn-primary px-5" > <a href="registerTeacher.jsp" style="text-decoration: none; color: inherit;">Previous Page</a></button>
                </div>
    </div>
</body>
</html>