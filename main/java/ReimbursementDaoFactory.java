public class ReimbursementDaoFactory {

    private static ReimbursementDao daoReimbursment;

    private ReimbursementDaoFactory() {

    }

    public static ReimbursementDao getReimbursementDao() {
        if (daoReimbursment == null) {
            daoReimbursment = new ReimbursementDao();
        }

        return daoReimbursment;
    }
}

