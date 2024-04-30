package model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "tbl_student_reg")
public class StudentRegistration {
	
	@Id
	@Column(name = "reg_id")
	private String regId;
	
	@Column(name = "reg_date")
	private LocalDate regDate;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "semester_id")
	private Semester semester;

	public StudentRegistration() {
		super();
	}

	public StudentRegistration(String regId) {
		super();
		this.regId = regId;
	}

	public StudentRegistration(String regId, LocalDate regDate, Student student, Semester semester) {
		super();
		this.regId = regId;
		this.regDate = regDate;
		this.student = student;
		this.semester = semester;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	
}
