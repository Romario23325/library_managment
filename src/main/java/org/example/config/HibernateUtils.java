package org.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;



import java.util.Objects;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        if (Objects.isNull(sessionFactory)) {
            Configuration configuration = new Configuration();
            configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }




    public class HibernateUtil {
        private static SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public static void shutdown() {
            getSessionFactory().close();
        }
    }

}
