package model;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "table_student")
public class Student {
	@Id
	@Column(name = "reg_number")
	private String regNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dob")
	private LocalDate dateOfBirth;
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentCourse> studentCourse = new ArrayList<>();
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentRegistration> studentRegistration = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department")
	private AcademicUnit department;

	public Student() {
		super();
	}

	public Student(String regNo) {
		super();
		this.regNo = regNo;
	}

	public Student(String regNo, String name, LocalDate dateOfBirth, List<StudentCourse> studentCourse,
			List<StudentRegistration> studentRegistration, AcademicUnit department) {
		super();
		this.regNo = regNo;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.studentCourse = studentCourse;
		this.studentRegistration = studentRegistration;
		this.department = department;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public List<StudentRegistration> getStudentRegistration() {
		return studentRegistration;
	}

	public void setStudentRegistration(List<StudentRegistration> studentRegistration) {
		this.studentRegistration = studentRegistration;
	}

	public AcademicUnit getDepartment() {
		return department;
	}

	public void setDepartment(AcademicUnit department) {
		this.department = department;
	}
	
	
	

}
