package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.Semester;
import model.Teacher;

public class TeacherDao {
	
	// Save Student
    public void registerTeacher(Teacher theTeacher) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theTeacher);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateTeacher(Teacher theTeacher) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theTeacher);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteTeacher(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            Teacher theTeacher = session.get(Teacher.class, id);
            if (theTeacher != null) {
                session.delete(theTeacher);
                System.out.println(" records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM Teacher", Teacher.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
    public Teacher findById(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
        	Query query = (Query) session.createQuery("select teacher from Teacher teacher where teacher.code = :id");
            query.setParameter("id", id);
            return (Teacher) ((org.hibernate.query.Query<Teacher>) query).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
