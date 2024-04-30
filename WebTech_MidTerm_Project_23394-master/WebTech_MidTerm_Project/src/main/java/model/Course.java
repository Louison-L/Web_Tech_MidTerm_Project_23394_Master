package model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "table_course")
public class Course {
	
	@Id
	@Column(name = "course_code")
	private String courseCode;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<StudentCourse> studentCourse = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	private List<Teacher> teachers = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	
	private Set<Semester> semesters = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department")
	private AcademicUnit department;

	public Course() {
		super();
	}

	public Course(String courseCode) {
		super();
		this.courseCode = courseCode;
	}

	public Course(String courseCode, String courseName, String description, List<StudentCourse> studentCourse,
			List<Teacher> teachers, Set<Semester> semesters, AcademicUnit department) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.description = description;
		this.studentCourse = studentCourse;
		this.teachers = teachers;
		this.semesters = semesters;
		this.department = department;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(Set<Semester> semesters) {
		this.semesters = semesters;
	}

	public AcademicUnit getDepartment() {
		return department;
	}

	public void setDepartment(AcademicUnit department) {
		this.department = department;
	}

	
	
	
	

}
