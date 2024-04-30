package services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dao.AcademicUnitDao;
import dao.CourseDao;
import dao.SemesterDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Semester;


@WebServlet(urlPatterns = "/semester")
public class SemesterService extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
        	String semName = request.getParameter("name");
            String semId = request.getParameter("code");
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
            Semester semester = new Semester();
            semester.setSemName(semName);
            semester.setSemId(semId);
            semester.setStartDate(startDate);
            semester.setEndDate(endDate);
            SemesterDao semesterService = new SemesterDao();
            semesterService.registerSemester(semester);
        } else if ("update".equals(action)) {
        	String semName = request.getParameter("name");
            String semId = request.getParameter("code");
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
            Semester semester = new Semester();
            semester.setSemName(semName);
            semester.setSemId(semId);
            semester.setStartDate(startDate);
            semester.setEndDate(endDate);
            SemesterDao semesterService = new SemesterDao();
            semesterService.updateSemester(semester);
            
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

        response.sendRedirect("displaySemester.jsp");
    }

}

