import DAO.DepartmentDAO;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import records.GenerateRecords;
import util.H2SessionUtil;

public class DepartmentDaoTest {

    private Session session;
    private DepartmentDAO dao;

    @Before
    public void initialization(){
        session = H2SessionUtil.getH2Session();
        GenerateRecords.generate(session);
        dao = new DepartmentDAO(session);
    }

    @After
    public void rollbackTransaction() {
        GenerateRecords.deleteAllRecords(session);
        session.close();
    }


    @Test
    public void getAllActiveDepartmentsHQLPositive(){
        assertEquals( 2 , dao.getAllActiveDepartmentHQL().size() );
    }

    @Test
    public void getAllActiveDepartmentsCriteriaPositive(){
        assertEquals( 2 , dao.getAllActiveDepartmentCriteria().size() );
    }

    @Test
    public void getAllActiveDepartmentsHQLNegative(){
        assertNotEquals(1 , dao.getAllActiveDepartmentHQL().size() );
    }

    @Test
    public void getAllActiveDepartmentsCriteriaNegative(){
        assertNotEquals(1 , dao.getAllActiveDepartmentCriteria().size() );
    }

}
