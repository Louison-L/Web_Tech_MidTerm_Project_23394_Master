package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;

import model.StudentCourse;

public class StudentCourseDao {
	// Save Student
    public void registerStudent(StudentCourse theStudentCourse) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theStudentCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateStudent(StudentCourse theStudentCourse) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theStudentCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteStudent(Integer id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            StudentCourse theStudentCourse = session.get(StudentCourse.class, id);
            if (theStudentCourse != null) {
                session.delete(theStudentCourse);
                System.out.println(" records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<StudentCourse> getAllStudentCourses() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM StudentCourse", StudentCourse.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<StudentCourse> getStudentsByCourses(StudentCourse course) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = (Query) ss.createQuery("select studentCourse from StudentCourse studentCourse where studentCourse.course = :course");
			query.setParameter("course", course);
			return ((org.hibernate.query.Query<StudentCourse>) query).list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

}
