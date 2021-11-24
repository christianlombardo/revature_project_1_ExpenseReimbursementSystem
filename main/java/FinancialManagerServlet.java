import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class FinancialManagerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ReimbursementDao daoReimbursement = ReimbursementDaoFactory.getReimbursementDao();
        EmployeeDao daoEmployee =  EmployeeDaoFactory.getEmployeeDao();

            List<Reimbursement> reimbursements = daoReimbursement.readByTicketStatus(Reimbursement.hmap.get("PENDING"));

            request.getRequestDispatcher("FinanceNavbar.html").include(request, response);

            out.println(
                    "<style>body{background-color:#666699}</style>" +
                            "<div class=\"wrapper container\"" +
                            "<div class=\"row g-3\">" +
                            "<div class=\"col-md-12\">" +
                            "<h1>User Profile</h1>" +
                            "</div>" +
                            "<div class=\"col-md-12\">" +
                            "<table class=\"table table-bordered table-dark \">" +
                                "<tr>\n" +
                                "<th>Employee Id</th>\n" +
                                "<th>Employee Name</th>\n" +
                                "<th>Username</th>\n" +
                                "<th>Ticket Detail</th>\n" +
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
                        "<td>" + reimbursement.getExpenseDetail() + "</td>\n" +
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
                        "&dateEnd=" + reimbursement.getDateEnd() +
                        "&employeeId=" + reimbursement.getEmployeeId() +
                        "\" style=\"color: blue\">" +
                        "APPROVE</a></td>\n" +
                        "<td><a href=\"UpdateStatusServlet?reimbursementId=" + reimbursement.getTicketNumber() + "&status=" + Reimbursement.hmap.get("DENIED") +
                        "&expenseDetail=" + reimbursement.getExpenseDetail() +
                        "&amount=" + reimbursement.getAmount() +
                        "&dateStart=" + reimbursement.getDateStart() +
                        "&dateEnd=" + reimbursement.getDateEnd() +
                        "&employeeId=" + reimbursement.getEmployeeId() +
                        "\" style=\"color: blue\">" +
                        "DENY</a></td>\n" +
                        "</tr>");
            }
            out.println("</table>" +
                    "</div>" +
                    "</div></div>");
        }

    }
