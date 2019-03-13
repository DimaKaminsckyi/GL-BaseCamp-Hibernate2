import DAO.DepartmentDAO;
import DAO.WorkersDao;
import entity.Availability;
import entity.Department;
import entity.Workers;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        DepartmentDAO departmentDAO = new DepartmentDAO();
        WorkersDao workersDao = new WorkersDao();

        /* Save object */
        Department department = new Department("From" , false);
        departmentDAO.addDepartment(department);

        /* Update object */
        List<Workers> workersList = new ArrayList<>();

        Workers workers = new Workers(20 , Availability.FullTime , "Dima");
        workers.setDepartment(department);
        workersList.add(workers);

        department.setWorkers(workersList);
        departmentDAO.updateDepartment(department);

        /* Delete object */
        departmentDAO.delete(department);

        /* Find object by ID */
        Workers byID = workersDao.findById(1);
        System.out.println(byID);

        /* Find all objects */
        System.out.println(departmentDAO.findAll());
    }
}
