package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {

    // Static SessionFactory (only one for whole app)
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Build session factory using hibernate.cfg.xml
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to access SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
