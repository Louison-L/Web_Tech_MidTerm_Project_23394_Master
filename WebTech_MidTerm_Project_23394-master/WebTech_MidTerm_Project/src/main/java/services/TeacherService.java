package services;

import java.io.IOException;
import java.util.HashSet;

import dao.AcademicUnitDao;
import dao.TeacherDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AcademicUnit;
import model.EQualification;
import model.Teacher;


@WebServlet(urlPatterns = "/saveTeacher")
public class TeacherService extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
        	String name = request.getParameter("name");
            String code = request.getParameter("code");
            String qualificationStr = request.getParameter("teacherType");
            EQualification qualification = EQualification.valueOf(qualificationStr);
            System.out.println("Hi");
            Teacher teacher = new Teacher(code, name, qualification, new HashSet<>());
            /* Teacher teacher = new Teacher(code, name, qualification, new ArrayList<>()); */
            System.out.println("Hi");
            TeacherDao dao = new TeacherDao();
            dao.registerTeacher(teacher);
            System.out.println("Hi");
            
			 
        	renderJSP(request, response);
            return;
            // ... (existing code)
        } else if ("update".equals(action)) {
        	
        	
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
	    request.getRequestDispatcher("displayTeacher.jsp").forward(request, response);
	}

}
