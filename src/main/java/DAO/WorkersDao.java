package DAO;

import entity.Workers;
import org.hibernate.Session;
import util.SessionFactoryUtil;

import java.util.List;

public class WorkersDao {

    public void addWorkers(Workers workers) {
        Session session = SessionFactoryUtil.getSession().openSession();
        session.save(workers);
        session.close();
    }

    public void updateWorksers(Workers workers) {
        Session session = SessionFactoryUtil.getSession().openSession();
        session.update(workers);
        session.close();
    }

    public Workers findById(int id) {
        Session session = SessionFactoryUtil.getSession().openSession();
        Workers worker = session.get(Workers.class , id);
        session.close();
        return worker;
    }

    public void delete(Workers entity) {
        Session session = SessionFactoryUtil.getSession().openSession();
        session.delete(entity);
        session.close();
    }
    public List<Workers> findAll() {
        Session session = SessionFactoryUtil.getSession().openSession();
        List<Workers> workers = (List<Workers>) session.createQuery("from Workers").list();
        session.close();
        return workers;
    }
}
