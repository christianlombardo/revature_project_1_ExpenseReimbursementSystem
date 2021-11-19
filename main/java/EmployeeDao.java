import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.List;

public class EmployeeDao implements DAO<Employee> {

    private static EmployeeDao daoEmployee;
    Configuration cfg;
    SessionFactory factory;

    EmployeeDao() {

        // Create Configuration Object
        cfg = new Configuration();

        // read the configuration and load the
        cfg.configure("hibernate.cfg.xml");

        // create the factory
        factory = cfg.buildSessionFactory();


    }


    @Override
    public void insert(Employee obj) {

    }

    @Override
    public Employee readById(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> readAll() {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public boolean login(Employee employee) {

        // open the session
        Session session = factory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee WHERE username := username AND password := password";
        Query query = session.createQuery(hql);
        query.setParameter("username", employee.getUsername());
        query.setParameter("password", employee.getPassword());
        Employee result = (Employee)query.list();

        boolean flag = false;
        if(employee.getUsername().equals(result.getUsername()) && employee.getPassword().equals(employee.getPassword())) {
            flag = true;
        }

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return flag;
    }

    @Override
    public void logout(Employee employee) {

    }
}
