package util;

import entity.Department;
import entity.Workers;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class H2SessionUtil {

    private static final SessionFactory h2SessionFactory;

    static {
        try {
            Properties properties= new Properties();

            properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            properties.put("hibernate.connection.driver_class", "org.h2.Driver");
            properties.put("hibernate.connection.url", "jdbc:h2:~/test");
            properties.put("hibernate.connection.username", "sa");
            properties.put("hibernate.connection.password", "sa");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.hbm2ddl.auto", "create");

            Configuration config = new Configuration();

            config.setProperties(properties);

            config.addAnnotatedClass(Department.class);
            config.addAnnotatedClass(Workers.class);

            h2SessionFactory = config.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getH2Session() throws HibernateException {
        return h2SessionFactory.openSession();
    }
}

