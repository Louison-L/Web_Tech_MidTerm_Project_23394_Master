package services;

import java.io.IOException;
import java.time.LocalDate;

import dao.AcademicUnitDao;
import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AcademicUnit;
import model.EAcademicUnit;



@WebServlet(urlPatterns = "/saveAcademicUnit")
public class AcademicService extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            // Handle insert operation
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
			/* response.sendRedirect("displayAcademic.jsp"); */
			/*
			 * request.getRequestDispatcher("displayAcademic.jsp").forward(request,
			 * response);
			 */
        	renderJSP(request, response);
            return;
            // ... (existing code)
        } else if ("update".equals(action)) {
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
        	
        	
        	unitService.updateAcademic(unit);
			/* response.sendRedirect("displayAcademic.jsp"); */
			/*
			 * request.getRequestDispatcher("displayAcademic.jsp").forward(request,
			 * response);
			 */
        	renderJSP(request, response);
            return;
            
        } else if ("delete".equals(action)) {
            // Handle delete operation
        	AcademicUnitDao unitService = new AcademicUnitDao();
        	AcademicUnit unit = new AcademicUnit();
            String academicCode = request.getParameter("code");
            AcademicUnit academicCodes = unitService.findById(academicCode);
            
            unitService.deleteAcademicUnit(academicCodes);
            renderJSP(request, response);
            return;
        }

		/* response.sendRedirect("displayStudents.jsp"); */
		/*
		 * request.getRequestDispatcher("displayAcademic.jsp").forward(request,
		 * response);
		 */
        renderJSP(request, response);
    }
	
	private void renderJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("displayAcademic.jsp").forward(request, response);
	}


}
