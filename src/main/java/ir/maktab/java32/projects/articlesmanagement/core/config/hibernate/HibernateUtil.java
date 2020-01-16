package ir.maktab.java32.projects.articlesmanagement.core.config.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Session firstSession;

    private static Session secondSession;

    static {
        SessionFactory firstSessionFactory = new Configuration().configure("hibernate.db1.cfg.xml").buildSessionFactory();
        firstSession = firstSessionFactory.openSession();

        SessionFactory secondSessionFactory = new Configuration().configure("hibernate.db2.cfg.xml").buildSessionFactory();
        secondSession = secondSessionFactory.openSession();
    }

    public static Session getFirstSession() {
        return firstSession;
    }

    public static Session getSecondSession() {
        return secondSession;
    }
}
