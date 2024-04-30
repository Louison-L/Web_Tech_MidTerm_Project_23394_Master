package model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "table_academic_unit")
public class AcademicUnit {
	
	@Id
	@Column(name = "unit_code")
	private String code;
	
	@Column(name = "unit_name")
	private String name;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "academic_unit")
	private EAcademicUnit academicUnit;
	
	@OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
	private List<AcademicUnit> faculties;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AcademicUnit faculty;
	
	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
	private List<AcademicUnit> departments;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Student> students;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AcademicUnit program;

	public AcademicUnit() {
		super();
	}

	public AcademicUnit(String code) {
		super();
		this.code = code;
	}

	public AcademicUnit(String code, String name, EAcademicUnit academicUnit, List<AcademicUnit> faculties,
			AcademicUnit faculty, List<AcademicUnit> departments, List<Student> students, List<Course> courses,
			AcademicUnit program) {
		super();
		this.code = code;
		this.name = name;
		this.academicUnit = academicUnit;
		this.faculties = faculties;
		this.faculty = faculty;
		this.departments = departments;
		this.students = students;
		this.courses = courses;
		this.program = program;
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

	public EAcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(EAcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	public List<AcademicUnit> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<AcademicUnit> faculties) {
		this.faculties = faculties;
	}

	public AcademicUnit getFaculty() {
		return faculty;
	}

	public void setFaculty(AcademicUnit faculty) {
		this.faculty = faculty;
	}

	public List<AcademicUnit> getDepartments() {
		return departments;
	}

	public void setDepartments(List<AcademicUnit> departments) {
		this.departments = departments;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public AcademicUnit getProgram() {
		return program;
	}

	public void setProgram(AcademicUnit program) {
		this.program = program;
	}
	
	
	@Override
	public String toString() {
	    return "AcademicUnit [code=" + code + ", name=" + name + ", academicUnit=" + academicUnit + ", program="
	            + program + ", faculties=" + faculties + ", faculty=" + faculty + ", departments=" + departments
	            + ", student=" + students + ", courses=" + courses + "]";
	}

	
	

}
