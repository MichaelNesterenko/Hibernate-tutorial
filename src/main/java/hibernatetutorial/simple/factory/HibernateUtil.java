package hibernatetutorial.simple.factory;

import hibernatetutorial.simple.entity.Department;
import hibernatetutorial.simple.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private HibernateUtil() {}

	private static SessionFactory sessionFactory;

	private static synchronized void createSessionFactory() {
		if (sessionFactory != null) {
			return;
		}

		try {
		sessionFactory = new Configuration()
			.configure()
			.addAnnotatedClass(Employee.class)
			.addAnnotatedClass(Department.class)
			.buildSessionFactory();
			//.buildSessionFactory(new ServiceRegistryBuilder().buildServiceRegistry());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session createSession() {
		if (sessionFactory == null) {
			createSessionFactory();
		}
		return sessionFactory.openSession();
	}
}
