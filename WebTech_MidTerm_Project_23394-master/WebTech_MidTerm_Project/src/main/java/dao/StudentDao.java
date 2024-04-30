package dao;

import java.util.List;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Student;

public class StudentDao {
	
	
	// Save Student
    public void registerStudent(Student theStudent) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theStudent);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateStudent(Student theStudent) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theStudent);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
		/*
		 * public void deleteStudent(String id) { try (Session session =
		 * HibernateUtility.getSession().openSession()) { Transaction transaction =
		 * session.beginTransaction(); Student theStudent = session.get(Student.class,
		 * id); if (theStudent != null) { session.delete(theStudent);
		 * System.out.println("Student's records have been deleted"); }
		 * transaction.commit(); } catch (Exception e) { e.printStackTrace(); } }
		 */
    
    public void deleteStudent(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Get the Student object by id
            Student theStudent = session.get(Student.class, id);

            if (theStudent != null) {
                // Remove any associated StudentCourse and StudentRegistration objects
                theStudent.getStudentCourse().clear();
                theStudent.getStudentRegistration().clear();

                // Delete the Student object
                session.delete(theStudent);
                System.out.println("Student's records have been deleted");
            } else {
                System.out.println("Student with id " + id + " not found");
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<Student> getAllStudents() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
    public Student findById(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = (Query) session.createQuery("SELECT student FROM Student student WHERE student.regNo = :id");
            query.setParameter("id", id);
            return (Student) ((org.hibernate.query.Query<Student>) query).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
