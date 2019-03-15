package records;

import entity.Availability;
import entity.Department;
import entity.Workers;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenerateRecords{

    public static void generate(Session session) {
        session.beginTransaction();

        Department department = new Department("department1", true);
        Department department1 = new Department("department2", false);
        Department department2 = new Department("department3", true);


        Workers workers1 = new Workers(20 , Availability.FullTime  , "worker1" ,department);
        Workers workers2 = new Workers(20 , Availability.PartTime  , "worker2" ,department1);
        Workers workers3 = new Workers(20 , Availability.FullTime  , "worker3" ,department);

        session.saveOrUpdate(department);
        session.saveOrUpdate(department1);
        session.saveOrUpdate(department2);

        session.saveOrUpdate(workers1);
        session.saveOrUpdate(workers2);
        session.saveOrUpdate(workers3);


        session.getTransaction().commit();
    }


    public static void deleteAllRecords(Session session){
        Transaction transaction = session.getTransaction();
        try{
        transaction.begin();
        session.createQuery("DELETE FROM Workers").executeUpdate();
        session.createQuery("DELETE FROM Department").executeUpdate();

        transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }

    }
}

