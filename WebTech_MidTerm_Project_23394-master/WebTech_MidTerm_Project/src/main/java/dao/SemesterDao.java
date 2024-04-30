package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import model.Semester;

public class SemesterDao {
	
	// Save Student
    public void registerSemester(Semester theSemester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theSemester);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateSemester(Semester theSemester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theSemester);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteSemester(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            Semester theSemester = session.get(Semester.class, id);
            if (theSemester != null) {
                session.delete(theSemester);
                System.out.println(" records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<Semester> getAllSemesters() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM Semester", Semester.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
    public Semester findById(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
        	Query query = (Query) session.createQuery("select semester from Semester semester where semester.semId = :id");
            query.setParameter("id", id);
            return (Semester) ((org.hibernate.query.Query<Semester>) query).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
