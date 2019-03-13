package util;

import entity.Department;
import entity.Workers;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionFactoryUtil {

    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop= new Properties();

            prop.setProperty("hibernate.connection.url",  "jdbc:mysql://localhost:3306/task");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "123123qwe");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            prop.setProperty("hibernate.hbm2ddl.auto", "update");

            Configuration config = new Configuration();

            config.setProperties(prop);

            config.addAnnotatedClass(Department.class);
            config.addAnnotatedClass(Workers.class);

            concreteSessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSession() throws HibernateException {
        return concreteSessionFactory;
    }
}
