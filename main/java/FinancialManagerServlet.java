import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinancialManagerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int i= 1;
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("FinanceNavbar.html").include(request, response);

        // see all pending reimbursements
        List<Employee> employees = new ArrayList<>();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Iterator iterator = reimbursements.iterator();
        out.println(
                "<style>body{background-color:grey}</style>" +       
                        "<div class=\"container\"" +
                        "<div class=\"row g-3\">" +
                        "<div class=\"col-md-12\">" +
                        "<h1>User Profile</h1>" +
                        "</div>" +
                        "<div class=\"col-md-12\">" +
                        "<table class=\"table table-bordered table-dark table-responsive\">" +
                        "<tr>\n" +
                        "<th>ID</th>\n" +
                        "<th>Name</th>\n" +
                        "<th>Username</th>\n" +
                        "<th>Amount</th>\n" +
                        "<th>Date</th>\n" +
                        "<th>Ticket Number</th>\n" +
                        "<th>Ticket Status</th>\n" +
                        "</tr>");

        while(iterator.hasNext()){
            i++;
            //employee
            //employee infor
            if (reimbursements.get(i).getEmployeeId() == employees.get(i).getEmployeeId()) {
                out.println("<tr>\n" +
                        "<td>" + employees.get(i).getEmployeeId() + "</td>\n" +
                        "<td>" + employees.get(i).getName() + "</td>\n" +
                        "<td>" + employees.get(i).getUsername() + "</td>\n" +
                        "<td>" + reimbursements.get(i).getAmount() + "</td>\n" +
                        "<td>" + reimbursements.get(i).getDateStart() + "</td>\n" +
                        "<td>" + reimbursements.get(i).getDateEnd() + "</td>\n" +
                        "<td>" + reimbursements.get(i).getTicketStatus() + "</td>\n" +
                        "</tr>");
            }
        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");




    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int i = 1;
        FinancialManagerDao financialManagerDao = FinancialManagerDaoFactory.getDaoFinancialManager();
        ReimbursementDao daoReimbursement = ReimbursementDaoFactory.getReimbursementDao();
        EmployeeDao daoEmployee =  EmployeeDaoFactory.getEmployeeDao();

        // FinancialManager login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        FinancialManager financialManager = new FinancialManager(username, password);
        //out.println("username = " + financialManager.getUsername() + ", password =" + financialManager.getPassword());

        if (financialManagerDao.login(financialManager)) {

            // display all Pending requests
            List<Reimbursement> reimbursements = daoReimbursement.readByTicketStatus(Reimbursement.hmap.get("PENDING"));
            //List<Integer> employeeIds = new ArrayList<>();
//            for (Reimbursement reimbursement : reimbursements) {
//                employeeIds.add(reimbursement.getEmployeeId());
//            }

            request.getRequestDispatcher("FinanceNavbar.html").include(request, response);
            out.println(
                    "<style>body{background-color:grey}</style>" +
                            "<header>head</head>" +
                            "<div class=\"container\"" +
                            "<div class=\"row g-3\">" +
                            "<div class=\"col-md-12\">" +
                            "<h1>User Profile</h1>" +
                            "</div>" +
                            "<div class=\"col-md-12\">" +
                            "<table class=\"table table-bordered table-dark table-responsive\">" +
                            "<tr>\n" +
                            "<th>ID</th>\n" +
                            "<th>Employee Name</th>\n" +
                            "<th>Username</th>\n" +
                            "<th>Amount</th>\n" +
                            "<th>Start Date</th>\n" +
                            "<th>End Date</th>\n" +
                            "<th>Ticket Number</th>\n" +
                            "<th>Ticket Status</th>\n" +
                            "<th>Approve</th>\n" +
                            "<th>Reject</th>\n" +
                            "</tr>");

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

            Iterator iterator = reimbursements.iterator();
            while(iterator.hasNext()) {
                Reimbursement reimbursement = (Reimbursement)iterator.next();

                // get employee data from the database
                Employee employee = daoEmployee.readById(reimbursement.getEmployeeId());

                    out.println("<tr>\n" +
                            "<td>" + employee.getEmployeeId() + "</td>\n" +
                            "<td>" + employee.getName() + "</td>\n" +
                            "<td>" + employee.getUsername() + "</td>\n" +
                            "<td>" + currencyFormat.format(reimbursement.getAmount()) + "</td>\n" +
                            "<td>" + reimbursement.getDateStart() + "</td>\n" +
                            "<td>" + reimbursement.getDateEnd() + "</td>\n" +
                            "<td>" + reimbursement.getTicketNumber() + "</td>\n" +
                            "<td>" + Reimbursement.getStatusName(reimbursement.getTicketStatus()) + "</td>\n" + /*
                            "<td><button onclick=\"getElementById('demo')\">Approve</button></td>\n" +
                            "<td><button onclick=\"getElementById('demo')\">Reject</button></td>\n" + */
                            "<td><a href=\"UpdateStatusServlet?reimbursementId=" + reimbursement.getTicketNumber() + "&status=" + Reimbursement.hmap.get("APPROVED") +
                            "&expenseDetail=" + reimbursement.getExpenseDetail() +
                            "&amount=" + reimbursement.getAmount() +
                            "&dateStart=" + reimbursement.getDateStart() +
                            "&dateEnd=" + reimbursement.getDateEnd()+
                            "\" style=\"color: blue\">" +
                            "APPROVE</a></td>\n" +
                            "<td><a href=\"UpdateStatusServlet?reimbursementId=" + reimbursement.getTicketNumber() + "&status=" + Reimbursement.hmap.get("DENIED") +
                            "&expenseDetail=" + reimbursement.getExpenseDetail() +
                            "&amount=" + reimbursement.getAmount() +
                            "&dateStart=" + reimbursement.getDateStart() +
                            "&dateEnd=" + reimbursement.getDateEnd()+
                            "\" style=\"color: blue\">" +
                            "DENY</a></td>\n" +
                            "</tr>");
            }
            out.println("</table>" +
                    "</div>" +
                    "</div></div>");

        }
        else{
                out.println("<h1>please check you username and password.</h1>");
            }


            // get all Employees out in a LIST
            // get all Reimbursement put in a LIST
            //
            List<Employee> employees = new ArrayList<>();
            List<Reimbursement> reimbursements = new ArrayList<>();

            //Employee employee = (Employee)httpSession.getAttribute("employee");


        }

    }

