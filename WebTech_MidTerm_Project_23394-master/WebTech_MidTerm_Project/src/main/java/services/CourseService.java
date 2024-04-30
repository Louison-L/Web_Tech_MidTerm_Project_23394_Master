package services;

import java.io.IOException;
import java.util.List;

import dao.AcademicUnitDao;
import dao.CourseDao;
import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AcademicUnit;
import model.Course;

@WebServlet(urlPatterns = "/courseService")
public class CourseService extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            // Handle insert operation
        	AcademicUnitDao unitService = new AcademicUnitDao();
            List<AcademicUnit> units = unitService.findByUnitType("DEPARTMENT");
        	CourseDao courseService = new CourseDao();
            Course theCourse = new Course();
            String courseName = request.getParameter("name");
            String courseCode = request.getParameter("code");
            String description = request.getParameter("description");
            
            String department = request.getParameter("dept");
            theCourse.setCourseCode(courseCode);
            theCourse.setCourseName(courseName);
            theCourse.setDescription(description);
            AcademicUnit unit = unitService.findById(department);
            theCourse.setDepartment(unit);
            courseService.registerCourse(theCourse);
            // ... (existing code)
        } else if ("update".equals(action)) {
        	AcademicUnitDao unitService = new AcademicUnitDao();
            List<AcademicUnit> units = unitService.findByUnitType("DEPARTMENT");
        	CourseDao courseService = new CourseDao();
            Course theCourse = new Course();
            String courseName = request.getParameter("name");
            String courseCode = request.getParameter("code");
            String description = request.getParameter("description");
            
            String department = request.getParameter("dept");
            theCourse.setCourseCode(courseCode);
            theCourse.setCourseName(courseName);
            theCourse.setDescription(description);
            AcademicUnit unit = unitService.findById(department);
            theCourse.setDepartment(unit);
            courseService.updateCourse(theCourse);
            
        } else if ("delete".equals(action)) {
            // Handle delete operation
            String courseCode = request.getParameter("code");
            CourseDao courseService = new CourseDao();
            courseService.deleteCourse(courseCode);
            
			/*
			 * StudentDao studentService = new StudentDao();
			 * studentService.deleteStudent(studentCode);
			 */
        }

        response.sendRedirect("displayCourses.jsp");
    }

}
