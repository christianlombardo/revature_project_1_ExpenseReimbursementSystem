import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FinancialManagerDao implements DAO<FinancialManager> {

    Configuration cfg;
    SessionFactory sessionFactory;

    @Override
    public void insert(FinancialManager financialManager) {

    }

    @Override
    public FinancialManager readById(FinancialManager financialManager) {
        return null;
    }

    @Override
    public List<FinancialManager> readAll() {
        return null;
    }

    @Override
    public void update(FinancialManager financialManager) {

    }

    @Override
    public void delete(FinancialManager financialManager) {

    }

    public boolean login(FinancialManager financialManager) {

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee WHERE username=:currusername AND password=:currpassword";
        Query query = session.createQuery(hql);
        query.setParameter("currusername", financialManager.getUsername());
        query.setParameter("currpassword", financialManager.getPassword());
        Employee result = (Employee)query.uniqueResult();

        boolean flag = false;
        if(financialManager.getUsername().equals(result.getUsername()) && financialManager.getPassword().equals(financialManager.getPassword())) {
            flag = true;
        }

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return flag;
    }

    public void logout(FinancialManager financialManager) {

    }


}
