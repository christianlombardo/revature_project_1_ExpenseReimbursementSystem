import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            if (reimbursements.get(i).getEmployeeId() == employees.get(i).getId()) {
                out.println("<tr>\n" +
                        "<td>" + employees.get(i).getId() + "</td>\n" +
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

        // FinancialManager login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        FinancialManager financialManager = new FinancialManager(username, password);
        //out.println("username = " + financialManager.getUsername() + ", password =" + financialManager.getPassword());

        if (financialManagerDao.login(financialManager)) {

            // display all Pending requests
            List<Reimbursement> results = daoReimbursement.readByTicketStatus(Reimbursement.hmap.get("PENDING"));
            List<Employee> employees = new ArrayList<>();
            Iterator iterator = results.iterator();
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
                            "<th>Name</th>\n" +
                            "<th>Username</th>\n" +
                            "<th>Amount</th>\n" +
                            "<th>Date</th>\n" +
                           "<th>Ticket Number</th>\n" +
                            "<th>Ticket Status</th>\n" +
                            "<th>Approve</th>\n" +
                            "<th>Reject</th>\n" +
                            "</tr>");

            while(iterator.hasNext()){
                i++;
                if (results.get(i).getEmployeeId() == employees.get(i).getId()) {
                    out.println("<tr>\n" +
                            "<td>" + employees.get(i).getId() + "</td>\n" +
                            "<td>" + employees.get(i).getName() + "</td>\n" +
                            "<td>" + employees.get(i).getUsername() + "</td>\n" +
                            "<td>" + results.get(i).getAmount() + "</td>\n" +
                            "<td>" + results.get(i).getDateStart() + "</td>\n" +
                            "<td>" + results.get(i).getDateEnd() + "</td>\n" +
                            "<td>" + results.get(i).getTicketStatus() + "</td>\n" +
                            "<td><button onclick=\"getElementById('demo')\">Approve</button></td>\n" +
                            "<td><button onclick=\"getElementById('demo')\">Reject</button></td>\n" +
                            "</tr>");
                }
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

