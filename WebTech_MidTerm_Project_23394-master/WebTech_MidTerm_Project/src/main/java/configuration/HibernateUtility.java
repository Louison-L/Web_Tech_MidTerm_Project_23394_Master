package configuration;

import org.hibernate.SessionFactory;
import java.util.Properties;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import model.AcademicUnit;
import model.Course;
import model.Semester;
import model.Student;
import model.StudentCourse;
import model.StudentRegistration;
import model.Teacher;
import model.Utilisateur;


public class HibernateUtility {
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSession() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/AUCA_db?createDatabaseIfNotExist=true");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "sql");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				
				// This help to put all properites into our configuration
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(StudentRegistration.class);
				configuration.addAnnotatedClass(AcademicUnit.class);
				configuration.addAnnotatedClass(Course.class);
				configuration.addAnnotatedClass(StudentCourse.class);
				configuration.addAnnotatedClass(Semester.class);
				configuration.addAnnotatedClass(Teacher.class);
				configuration.addAnnotatedClass(Utilisateur.class);
				
				
				
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	/*
	 * public static SessionFactory getSessionUser() { if(sessionFactory == null) {
	 * try { Configuration configuration = new Configuration();
	 * 
	 * // Hibernate settings equivalent to hibernate.cfg.xml's properties Properties
	 * settings = new Properties(); settings.put(Environment.DRIVER,
	 * "org.postgresql.Driver"); settings.put(Environment.URL,
	 * "jdbc:postgresql://localhost:5432/AUCA_db?createDatabaseIfNotExist=true")
	 * ; settings.put(Environment.USER, "postgres"); settings.put(Environment.PASS,
	 * "sql"); settings.put(Environment.DIALECT,
	 * "org.hibernate.dialect.PostgreSQLDialect");
	 * 
	 * settings.put(Environment.SHOW_SQL, "true");
	 * 
	 * settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	 * 
	 * settings.put(Environment.HBM2DDL_AUTO, "update");
	 * 
	 * 
	 * // This help to put all properites into our configuration
	 * configuration.setProperties(settings);
	 * configuration.addAnnotatedClass(Utilisateur.class);
	 * 
	 * 
	 * ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	 * .applySettings(configuration.getProperties()).build();
	 * System.out.println("Hibernate Java Config serviceRegistry created");
	 * sessionFactory = configuration.buildSessionFactory(serviceRegistry); return
	 * sessionFactory;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } return sessionFactory; }
	 * 
	 */
}
