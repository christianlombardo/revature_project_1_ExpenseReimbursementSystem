public class ReimbursementDaoFactory {

    private static ReimbursementDao daoReimbursment;

    private ReimbursementDaoFactory() {

    }

    public static ReimbursementDao getEmployeeDao() {
        if (daoReimbursment == null) {
            daoReimbursment = new ReimbursementDao();
        }

        return daoReimbursment;
    }
}

