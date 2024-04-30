package services;

import java.io.IOException;

import java.util.List;


import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Course;
import model.Student;
import model.StudentCourse;
@WebServlet(urlPatterns = "/studentCourse")
public class StudentCourseService extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            StudentDao studentService = new StudentDao();
            List<Student> students = studentService.getAllStudents();

            CourseDao courseService = new CourseDao();
            List<Course> courses = courseService.getAllCourses();
            // Handle insert operation
            String results = request.getParameter("id");
            
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
            regStudentCourse.registerStudent(studentCourse);
            // ... (existing code)
        } else if ("update".equals(action)) {
            StudentDao studentService = new StudentDao();
            List<Student> students = studentService.getAllStudents();

            CourseDao courseService = new CourseDao();
            List<Course> courses = courseService.getAllCourses();
            // Handle insert operation
            String results = request.getParameter("id");
            String change = request.getParameter("Recordid");
            int identifiant = Integer.parseInt(change);
            
            
            String studentCode = request.getParameter("student");
            String courseCode = request.getParameter("course");

            Student theStudent = studentService.findById(studentCode);
            Course theCourse = courseService.findById(courseCode);

            StudentCourse studentCourse = new StudentCourse();
            double marks = Double.parseDouble(results);
            studentCourse.setResults(marks);
            studentCourse.setId(identifiant);
            
            
            studentCourse.setCourse(theCourse);
            studentCourse.setStudent(theStudent);

            StudentCourseDao regStudentCourse = new StudentCourseDao();
            regStudentCourse.updateStudent(studentCourse);
            
        } else if ("delete".equals(action)) {
            // Handle delete operation
            String studentCode = request.getParameter("code");
            StudentDao studentService = new StudentDao();
            studentService.deleteStudent(studentCode);
        }

        response.sendRedirect("displayStudentCourse.jsp");
    }
	

}
