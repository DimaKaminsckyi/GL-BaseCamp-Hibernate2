import DAO.WorkersDao;
import static org.junit.Assert.*;

import entity.Availability;
import org.hibernate.Session;
import org.junit.*;
import records.GenerateRecords;
import util.H2SessionUtil;

public class WorkersDaoTest {

    private  Session session;
    private  WorkersDao dao;

    @Before
    public void initialization(){
        session = H2SessionUtil.getH2Session();
        dao = new WorkersDao(session);
        GenerateRecords.generate(session);
    }

    @After
    public void rollbackTransaction() {
        System.out.println(dao.findAll());
        GenerateRecords.deleteAllRecords(session);
        session.close();
    }

    @Test
    public void getWorkersByDepartmentIdAndAvaliabilityHQLPositive(){
        assertEquals(2 , dao.getWorkersByDepartmentIdAndAvailabilityHQL(1 , Availability.FullTime).size());
    }

    @Test
    public void getWorkersByDepartmentIdAndAvaliabilityCriteriaPositive(){
        assertEquals(2 , dao.getWorkersByDepartmentIdAndAvailabilityCriteria(1 , Availability.FullTime).size());
    }

    @Test
    public void getWorkersByDepartmentIdAndAvaliabilityHQLNegative(){
        assertNotEquals(1 , dao.getWorkersByDepartmentIdAndAvailabilityHQL(1 , Availability.FullTime).size());
    }

    @Test
    public void getWorkersByDepartmentIdAndAvaliabilityCriteriaNegative(){
        assertNotEquals(1 , dao.getWorkersByDepartmentIdAndAvailabilityHQL(1 , Availability.FullTime).size());
    }

}
