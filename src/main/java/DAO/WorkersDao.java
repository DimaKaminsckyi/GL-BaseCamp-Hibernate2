package DAO;

import entity.Availability;
import entity.Workers;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WorkersDao {

    private Session session;

    public WorkersDao(Session session){
        this.session = session;
    }

    public List<Workers> getWorkersByDepartmentIdAndAvailabilityHQL(int departmentId , Availability availability){
        Query query = session.
                createQuery("FROM Workers  " +
                        "WHERE department_id = :department" +
                        " AND" +
                        " availability = :a");
        query.setParameter("department" , departmentId);
        query.setParameter("a" , availability);
        List workers = query.list();
        return workers;
    }

    public List<Workers> getWorkersByDepartmentIdAndAvailabilityCriteria(int departmentId , Availability availability) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Workers> criteriaQuery = cb.createQuery(Workers.class);
        Root<Workers> root = criteriaQuery.from(Workers.class);
        criteriaQuery.select(root).where(cb.equal(root.get("department"), departmentId) ,
                cb.equal(root.get("availability") , availability));
        Query query = session.createQuery(criteriaQuery);
        List<Workers> workers = query.getResultList();
        return workers;
    }

    public void addWorkers(Workers workers) {
        session.save(workers);
    }

    public void updateWorksers(Workers workers) {
        session.update(workers);
    }

    public Workers findById(int id) {
        Workers worker = session.get(Workers.class , id);
        return worker;
    }

    public void delete(Workers entity) {
        session.delete(entity);
    }
    public List<Workers> findAll() {
        List<Workers> workers = (List<Workers>) session.createQuery("from Workers").list();
        return workers;
    }
}
