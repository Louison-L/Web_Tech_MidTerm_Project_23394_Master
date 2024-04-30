package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.Semester;
import model.StudentRegistration;

public class StudentRegistrationDao {
	
	// Save Student
    public void registerStudentRegistration(StudentRegistration registration) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(registration);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateSemester(StudentRegistration registration) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(registration);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteSemester(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            StudentRegistration registration = session.get(StudentRegistration.class, id);
            if (registration != null) {
                session.delete(registration);
                System.out.println(" records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<StudentRegistration> getAllStudentRegistration() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM StudentRegistration", StudentRegistration.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
    public List<StudentRegistration> getAllStudentAndSemester(Semester semester) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = (Query) ss.createQuery("select reg from StudentRegistration reg where reg.semester = :semester");
			query.setParameter("semester", semester);
			return ((org.hibernate.query.Query<StudentRegistration>) query).list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
