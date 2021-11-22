public class FinancialManagerDaoFactory {

    private static FinancialManagerDao daoFinancialManager;

    private FinancialManagerDaoFactory() {

    }

    public static FinancialManagerDao getDaoFinancialManager() {
        if (daoFinancialManager == null) {
            daoFinancialManager = new FinancialManagerDao();
        }

        return daoFinancialManager;
    }
}

