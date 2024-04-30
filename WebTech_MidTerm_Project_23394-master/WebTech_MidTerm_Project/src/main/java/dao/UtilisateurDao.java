package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import model.Utilisateur;

public class UtilisateurDao {
	
    public void registerUtilisateur(Utilisateur theUtilisateur) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theUtilisateur);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Utilisateur loginUtilisateur(String email, String password, String role) {
        try {
            Session ss = HibernateUtility.getSession().openSession();
            Query query = (Query) ss.createQuery("FROM Utilisateur WHERE email = :email AND password = :password AND role = :role");
            query.setParameter("email", email);
            query.setParameter("password", password);
            query.setParameter("role", role);
            Utilisateur utilisateur = (Utilisateur) ((org.hibernate.query.Query) query).uniqueResult();
            ss.close();
            return utilisateur;

        } catch (HibernateException ex) {
            ex.printStackTrace(); 
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
        return null;
    }


}
