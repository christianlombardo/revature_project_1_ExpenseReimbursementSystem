public class EmployeeDaoFactory {

    private static EmployeeDao daoEmployee;

    private EmployeeDaoFactory() {

    }

    public static EmployeeDao getEmployeeDao() {
        if (daoEmployee == null) {
            daoEmployee = new EmployeeDao();
        }

        return daoEmployee;
    }
}
