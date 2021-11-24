import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FinancialManagerViewAllServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            ReimbursementDao daoReimbursement = ReimbursementDaoFactory.getReimbursementDao();
            EmployeeDao daoEmployee =  EmployeeDaoFactory.getEmployeeDao();

            List<Integer> statuses = new ArrayList<>();
            statuses.add(Reimbursement.hmap.get("PENDING"));
            statuses.add(Reimbursement.hmap.get("APPROVED"));
            statuses.add(Reimbursement.hmap.get("DENIED"));

            List<Reimbursement> reimbursements = daoReimbursement.readByTicketStatuses(statuses);

            request.getRequestDispatcher("FinanceNavbar.html").include(request, response);
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
                            "<th>Employee Id</th>\n" +
                            "<th>Name</th>\n" +
                            "<th>Username</th>\n" +
                            "<th>Amount</th>\n" +
                            "<th>Start Date</th>\n" +
                            "<th>End Date</th>\n" +
                            "<th>Ticket Number</th>\n" +
                            "<th>Ticket Status</th>\n" +
                            "</tr>");

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

            Iterator iterator = reimbursements.iterator();
            while(iterator.hasNext()) {
                Reimbursement reimbursement = (Reimbursement)iterator.next();

                Employee employee = daoEmployee.readById(reimbursement.getEmployeeId());

                //if (reimbursement.getEmployeeId() == employees.get(i).getId()) {
                out.println("<tr>\n" +
                        "<td>" + employee.getEmployeeId() + "</td>\n" +
                        "<td>" + employee.getName() + "</td>\n" +
                        "<td>" + employee.getUsername() + "</td>\n" +
                        "<td>" + currencyFormat.format(reimbursement.getAmount()) + "</td>\n" +
                        "<td>" + reimbursement.getDateStart() + "</td>\n" +
                        "<td>" + reimbursement.getDateEnd() + "</td>\n" +
                        "<td>" + reimbursement.getTicketNumber()+ "</td>\n" +
                        "<td>" + Reimbursement.getStatusName(reimbursement.getTicketStatus()) + "</td>\n" +
                        "</tr>");

                //}
            }
            out.println("</table>" +
                    "</div>" +
                    "</div></div>");

        }
       /* else{
        String message = "Please enter a valid username and password";
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/LoginFailManager.jsp").forward(request, response);
    }*/
    }

