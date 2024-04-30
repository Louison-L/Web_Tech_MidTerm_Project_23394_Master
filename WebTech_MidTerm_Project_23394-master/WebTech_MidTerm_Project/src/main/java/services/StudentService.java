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
import model.Student;


@WebServlet(urlPatterns = "/StudentServlet")
public class StudentService extends HttpServlet{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        if ("insert".equals(action)) {
	            // Handle insert operation
	        	Student student = new Student();
	        	AcademicUnit academy = new  AcademicUnit();
	        	AcademicUnitDao unitService = new AcademicUnitDao();
	        	
	        	String studentName = request.getParameter("name");
	            String studentCode = request.getParameter("code");
	            String dob = request.getParameter("dob");
	            LocalDate localDate = LocalDate.parse(dob);
	            String department = request.getParameter("dept");
	            student.setName(studentName);
	            student.setRegNo(studentCode);
	            student.setDateOfBirth(localDate);
	            AcademicUnit unit = unitService.findById(department);
	            student.setDepartment(unit);
	        	StudentDao studentService = new StudentDao();
	            studentService.registerStudent(student);
	            // ... (existing code)
	        } else if ("update".equals(action)) {
	        	Student student = new Student();
	        	AcademicUnit academy = new  AcademicUnit();
	        	AcademicUnitDao unitService = new AcademicUnitDao();
	        	
	        	String studentName = request.getParameter("name");
	            String studentCode = request.getParameter("code");
	            String dob = request.getParameter("dob");
	            LocalDate localDate = LocalDate.parse(dob);
	            String department = request.getParameter("dept");
	            student.setName(studentName);
	            student.setRegNo(studentCode);
	            student.setDateOfBirth(localDate);
	            AcademicUnit unit = unitService.findById(department);
	            student.setDepartment(unit);
	        	StudentDao studentService = new StudentDao();
	        	studentService.updateStudent(student);
	            
	        } else if ("delete".equals(action)) {
	            // Handle delete operation
	            String studentCode = request.getParameter("code");
	            StudentDao studentService = new StudentDao();
	            studentService.deleteStudent(studentCode);
	        }

	        response.sendRedirect("displayStudents.jsp");
	    }

}
