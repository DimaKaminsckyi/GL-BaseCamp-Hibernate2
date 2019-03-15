package DAO;

import entity.Department;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentDAO {

    private Session session;

    public DepartmentDAO(Session session){
        this.session = session;
    }


    public List<Department> getAllActiveDepartmentHQL(){
        Query query = session.createQuery("FROM Department WHERE status = true");
        List departments = query.getResultList();
        return departments;
    }

    public List<Department> getAllActiveDepartmentCriteria(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = cb.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);
        criteriaQuery.select(root).where(cb.equal(root.get("status") , true ));
        Query query = session.createQuery(criteriaQuery);
        List<Department> departments = query.getResultList();
        return departments;
    }

    public void addDepartment(Department department) {
        session.save(department);
    }

    public void updateDepartment(Department department) {
        session.update(department);
    }

    public Department findById(int id) {
        Department dep = session.get(Department.class , id);
        return dep;
    }

    public void delete(Department entity) {
        session.delete(entity);
    }
    public List<Department> findAll() {
        List<Department> departments = (List<Department>) session.createQuery("from Department").list();
        return departments;
    }


}
