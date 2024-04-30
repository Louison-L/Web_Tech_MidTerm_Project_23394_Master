package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.Course;


public class CourseDao {
	
	// Save Student
    public void registerCourse(Course theCourse) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateCourse(Course theCourse) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteCourse(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            Course theCourse = session.get(Course.class, id);
            if (theCourse != null) {
                session.delete(theCourse);
                System.out.println("Student's records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
    public Course findById(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = (Query) session.createQuery("SELECT course FROM Course course WHERE course.courseCode = :id");
            query.setParameter("id", id);
            return (Course) ((org.hibernate.query.Query<Course>) query).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
