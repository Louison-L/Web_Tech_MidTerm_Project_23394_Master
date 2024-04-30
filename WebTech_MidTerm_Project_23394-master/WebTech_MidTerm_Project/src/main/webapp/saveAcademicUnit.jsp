<%@page import="dao.AcademicUnitDao"%>
<%@page import="model.AcademicUnit"%>
<%@page import="model.EAcademicUnit"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SaveAcademicUnit</title>
</head>
<body>

</body>
</html>

<% 
	AcademicUnitDao unitService = new AcademicUnitDao();
	AcademicUnit unit = new AcademicUnit();

	String unitName = request.getParameter("name");
	String unitCode = request.getParameter("code");
	String unitType = request.getParameter("unitType");

	EAcademicUnit unitValue = EAcademicUnit.valueOf(unitType);
	AcademicUnit grandPere = new AcademicUnit();
	
	if(unitType.equals("FACULTY")){
		String parentName = request.getParameter("prog");
		unit.setProgram(unitService.findById(parentName));
	}else if(unitType.equals("DEPARTMENT")){
		String parentName = request.getParameter("dept");
		unit.setFaculty(unitService.findById(parentName));
		//String grandFather = request.getParameter("prog");
		//unit.setProgram(unitService.findById(grandFather));
	}

	unit.setCode(unitCode);
	unit.setName(unitName);
	unit.setAcademicUnit(unitValue);
	
	
	unitService.registerAcademic(unit);
	response.sendRedirect("displayAcademic.jsp");
	
%>