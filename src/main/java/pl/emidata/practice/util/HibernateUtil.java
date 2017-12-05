package pl.emidata.practice.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.emidata.hibernate.demo.entity.Student;
import pl.emidata.practice.entities.Employee;

public class HibernateUtil {
    //XML based configuration
    private static SessionFactory sessionFactory;

    //Property based configuration
    private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
            sessionFactory = factory;
            System.out.println("Session factory ready");
            return sessionFactory;
        } catch (Throwable ex) {
            // making sure to log expression
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
