import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReimbursementDao implements DAO<Reimbursement>{

    Configuration cfg;
    SessionFactory sessionFactory;


    ReimbursementDao () {

        // create configuration object
        cfg = new Configuration();

        // read the configuration
        cfg.configure("hibernate.cfg.xml");

        // create the factory
        sessionFactory = cfg.buildSessionFactory();

    }

    @Override
    public void insert(Reimbursement reimbursement) {
        System.out.println(reimbursement.toString());

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        // hibernate save new reimbursement
        session.save(reimbursement);

        // commit the transaction
        t.commit();

        // close the session
        session.close();

    }

    @Override
    public Reimbursement readById(Reimbursement obj) {
        return null;
    }

    @Override
    public List<Reimbursement> readAll() {
        return null;
    }

    @Override
    public void update(Reimbursement obj) {

    }

    @Override
    public void delete(Reimbursement obj) {

    }

}
