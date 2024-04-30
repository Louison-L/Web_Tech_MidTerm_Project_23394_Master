package model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "table_teacher")
public class Teacher {
	
	@Id
	@Column(name = "teacher_code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private EQualification qualification;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_teachers_courses",
	joinColumns = @JoinColumn(name = "teacher_code"),
	inverseJoinColumns = @JoinColumn(name = "course_code"))
	private Set<Course> courses = new HashSet<>();

	public Teacher() {
		super();
	}

	public Teacher(String code) {
		super();
		this.code = code;
	}

	public Teacher(String code, String name, EQualification qualification, Set<Course> courses) {
		super();
		this.code = code;
		this.name = name;
		this.qualification = qualification;
		this.courses = courses;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EQualification getQualification() {
		return qualification;
	}

	public void setQualification(EQualification qualification) {
		this.qualification = qualification;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	
	


}
