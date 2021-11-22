import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDao implements DAO<Employee> {

    //private static EmployeeDao daoEmployee;
    Configuration cfg;
    SessionFactory sessionFactory;

    EmployeeDao() {

        // Create Configuration Object
        cfg = new Configuration();

        // read the configuration and load the
        cfg.configure("hibernate.cfg.xml");

        // create the factory
        sessionFactory = cfg.buildSessionFactory();

    }


    @Override
    public void insert(Employee employee) {
        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        // hibernate save to the database
        session.save(employee);

        // commit the transaction
        t.commit();

        // close the connection
        session.close();
    }

    @Override
    public Employee readById(int employeeId) {

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee WHERE employeeId=:currEmployeeId";
        Query query = session.createQuery(hql);
        query.setParameter("currEmployeeId", employeeId);
        Employee employee = (Employee)query.uniqueResult();

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return employee;

    }

    @Override
    public List<Employee> readAll() {

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee";
        Query query = session.createQuery(hql);
        List<Employee> results = query.list();

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return results;

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    public boolean login(Employee employee) {

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee WHERE username=:currusername AND password=:currpassword";
        Query query = session.createQuery(hql);
        query.setParameter("currusername", employee.getUsername());
        query.setParameter("currpassword", employee.getPassword());
        Employee result = (Employee)query.uniqueResult();

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


    public void logout(Employee employee) {

    }

    public Employee getEmployeeByUsernamePassword(String username, String password) {
        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee WHERE username=:currusername AND password=:currpassword";
        Query query = session.createQuery(hql);
        query.setParameter("currusername", username);
        query.setParameter("currpassword", password);
        Employee employee = (Employee)query.uniqueResult();

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return employee;
    }

}
