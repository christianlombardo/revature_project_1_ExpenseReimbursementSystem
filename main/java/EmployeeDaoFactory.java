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
<<<<<<< HEAD
}
=======
}
>>>>>>> 71d757a075768798ef5e3b259aaa1eddfb6d206b
