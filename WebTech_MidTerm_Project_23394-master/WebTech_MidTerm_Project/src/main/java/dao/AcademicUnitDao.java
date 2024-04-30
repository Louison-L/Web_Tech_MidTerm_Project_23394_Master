package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import model.AcademicUnit;
import model.EAcademicUnit;

public class AcademicUnitDao {
	
	// Save Student
    public void registerAcademic(AcademicUnit academic) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(academic);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateAcademic(AcademicUnit academic) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(academic);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
		/*
		 * public void deleteAcademic(String id) { try (Session session =
		 * HibernateUtility.getSession().openSession()) { Transaction transaction =
		 * session.beginTransaction(); AcademicUnit academic =
		 * session.get(AcademicUnit.class, id); if (academic != null) {
		 * session.delete(academic); System.out.println(" records have been deleted"); }
		 * transaction.commit(); } catch (Exception e) { e.printStackTrace(); } }
		 */
    
    public AcademicUnit deleteAcademicUnit(AcademicUnit unit) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtility.getSession().openSession();
            transaction = session.beginTransaction();
            
            session.delete(unit);
            
            transaction.commit();
            return unit;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    
    // Display All Students
    public List<AcademicUnit> getAllAcademics() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM AcademicUnit", AcademicUnit.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
	/*
	 * public AcademicUnit findByNames(String name) { try (Session session =
	 * HibernateUtility.getSession().openSession()) { Query query = (Query) session.
	 * createQuery("select academic from AcademicUnit academic where academic.name = :name"
	 * ); query.setParameter("name", name); return (AcademicUnit)
	 * ((org.hibernate.query.Query<AcademicUnit>) query).uniqueResult(); } catch
	 * (Exception e) { e.printStackTrace(); return null; } }
	 */
    
    public AcademicUnit findByNames(String name) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            org.hibernate.query.Query<AcademicUnit> query = session.createQuery("select academic from AcademicUnit academic where academic.name = :name", AcademicUnit.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


	 
    
	
    public AcademicUnit findById(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = (Query) session.createQuery("select academic from AcademicUnit academic where academic.code = :id");
            query.setParameter("id", id);
            return (AcademicUnit) ((org.hibernate.query.Query<AcademicUnit>) query).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
	
    public List<AcademicUnit> findByUnitType(String type) { 
        Session session = HibernateUtility.getSession().openSession(); 
        Query query = (Query) session.createQuery("select academic from AcademicUnit academic where academic.academicUnit = :type"); 
        query.setParameter("type", EAcademicUnit.valueOf(type)); 
        return ((org.hibernate.query.Query<AcademicUnit>) query).list(); 
    }

	 


}
