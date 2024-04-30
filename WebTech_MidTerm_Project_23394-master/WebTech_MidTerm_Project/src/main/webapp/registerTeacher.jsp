<%@page import="dao.AcademicUnitDao"%>
<%@page import="model.AcademicUnit"%>
<%@page import="model.Teacher"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="dao.TeacherDao"%>
<%@page import="model.EQualification"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    // Assuming EAcademicUnit is an enum
    EQualification[] academicUnits = EQualification.values();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f8f9fa;
    }
    .container {
        max-width: 800px;
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
                <h1 class="text-center mb-4">Teacher Registration</h1>
                <form action="saveTeacher" id="academicUnitForm" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name">Teacher Name</label>
                            <input type="text" class="form-control" name="name" id="name" >
                        </div>
                        <div class="form-group col-md-6">
                            <label for="code">Teacher Id</label>
                            <input type="text" class="form-control" id="code" name="code" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Teacher Qualification Type</label>
                            <select name="teacherType" class="form-control" id="unitType" >
                                <option value="none">-- Select Qualification Type --</option>
                                
                                <% for (EQualification unitType : academicUnits) { %>
                <option value="<%= unitType.name() %>"><%= unitType.getLabel() %></option>
            <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <%-- <div class="form-group col-md-6 divHide" id="FACULTY" style="display: none;">
                            <label for="prog">Program Name</label>
                            <select name="prog" id="prog" class="form-control">
                                <option value="none">-- Select Program --</option>
                                <%
                                AcademicUnitDao dao = new AcademicUnitDao();
                                List<AcademicUnit> programs = dao.findByUnitType("PROGRAM");
                                for(AcademicUnit program : programs){
                                %>
                                <option value="<%= program.getCode() %>"><%= program.getName() %></option>
                                <% } %>
                            </select>
                        </div> --%>
                        <%-- <div class="form-group col-md-6 divHide" id="DEPARTMENT" style="display: none;">
                            <label for="dept">Faculty Name</label>
                            <select name="dept" id="dept" class="form-control">
                                <option value="none">-- Select Faculty --</option>
                                <%
                                List<AcademicUnit> faculties = dao.findByUnitType("FACULTY");
                                for(AcademicUnit faculty : faculties){
                                %>
                                <option value="<%= faculty.getCode() %>"><%= faculty.getName() %></option>
                                <% } %>
                            </select> --%>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 divHide" id="DEFAULT" style="display: none;"></div>
                    </div>
                    <div class="form-group text-center">
                        <!-- <button type="submit" class="btn btn-primary px-5">Register a Teacher</button>
                        <button type="submit" class="btn btn-primary px-5">Update Teacher Info</button>
                        <button type="submit" class="btn btn-primary px-5" formaction="deleteUnit">Delete Teacher</button> -->
                        
                        <!-- <button type="button" onclick="window.location.href='displayAcademic.jsp';" class="btn btn-primary px-5">Display Unit</button> -->
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="insert">Save Teacher</button>
                        <button type="submit" class="btn btn-primary mr-2" name="action" value="update">Update Teacher</button>
                        <!-- <button type="submit" class="btn btn-primary px-5" formaction="deleteUnit">Delete Unit</button> -->
                        <div class="form-group text-center mt-3">
                        <button type="submit" class="btn btn-primary" name="action" value="delete">Delete Teacher Records</button>
                    </div>
                        
                    </div>
                </form>
                <div class="form-group text-center">
                <button type="submit" class="btn btn-primary px-5" > <a href="displayTeacher.jsp" style="text-decoration: none; color: inherit;">Display Unit</a></button>
                </div>
            </div>
        </div>
    </div>
      <%
    if("POST".equalsIgnoreCase(request.getMethod())){
    	String name = request.getParameter("name");
        String code = request.getParameter("code");
        String qualificationStr = request.getParameter("teacherType");
        EQualification qualification = EQualification.valueOf(qualificationStr);
        System.out.println("Hi");
        Teacher teacher = new Teacher(code, name, qualification, new HashSet<>());
        /* Teacher teacher = new Teacher(code, name, qualification, new ArrayList<>()); */
        System.out.println("Hi");
        TeacherDao dao = new TeacherDao();
        dao.updateTeacher(teacher);
        System.out.println("Hi");
         String action = request.getParameter("action");
        if ("insert".equals(action)) {
        	dao.updateTeacher(teacher);
        } else if ("update".equals(action)) {
            // Add code to update student information
        } else if ("delete".equals(action)) {
            // Add code to delete student records
        }
        /* response.sendRedirect("displayStudents.jsp"); */
    }
    %>
</body>
</html>