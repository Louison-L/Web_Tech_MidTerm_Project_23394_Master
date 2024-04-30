package services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import dao.SemesterDao;
import dao.StudentDao;
import dao.StudentRegistrationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Semester;
import model.Student;
import model.StudentRegistration;


@WebServlet(urlPatterns = "/studentRegistration")
public class StudentRegistrationService extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
        	
            StudentDao studentService = new StudentDao();
            List<Student> students = studentService.getAllStudents();

            SemesterDao semesterService = new SemesterDao();
            List<Semester> semesters = semesterService.getAllSemesters();
            String regId = request.getParameter("id");
            String regDate = request.getParameter("regDate");
            LocalDate date = LocalDate.parse(regDate);
            String studentCode = request.getParameter("student");
            String semCode = request.getParameter("semester");

            Student theStudent = studentService.findById(studentCode);
            Semester theSemester = semesterService.findById(semCode);

            StudentRegistration registration = new StudentRegistration();
            registration.setRegId(regId);
            registration.setRegDate(date);
            registration.setSemester(theSemester);
            registration.setStudent(theStudent);

            StudentRegistrationDao regService = new StudentRegistrationDao();
            regService.registerStudentRegistration(registration);
        } else if ("update".equals(action)) {
        	
            StudentDao studentService = new StudentDao();
            List<Student> students = studentService.getAllStudents();

            SemesterDao semesterService = new SemesterDao();
            List<Semester> semesters = semesterService.getAllSemesters();
            String regId = request.getParameter("id");
            String regDate = request.getParameter("regDate");
            LocalDate date = LocalDate.parse(regDate);
            String studentCode = request.getParameter("student");
            String semCode = request.getParameter("semester");

            Student theStudent = studentService.findById(studentCode);
            Semester theSemester = semesterService.findById(semCode);

            StudentRegistration registration = new StudentRegistration();
            registration.setRegId(regId);
            registration.setRegDate(date);
            registration.setSemester(theSemester);
            registration.setStudent(theStudent);

            StudentRegistrationDao regService = new StudentRegistrationDao();
            regService.updateSemester(registration);
        	
            
        } else if ("delete".equals(action)) {
            // Handle delete operation
            
            
			/*
			 * StudentDao studentService = new StudentDao();
			 * studentService.deleteStudent(studentCode);
			 */
        }

        response.sendRedirect("displayStudentRegistration.jsp");
    }

}
