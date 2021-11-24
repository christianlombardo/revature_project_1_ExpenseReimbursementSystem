import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeViewPastRequestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ReimbursementDao daoReimbursement = ReimbursementDaoFactory.getReimbursementDao();
        request.getRequestDispatcher("test.html").include(request, response);

        out.println(
                "<style>body{background-color:gray;}</style>" +
                        "<div class=\"wrapper container\"" +
                        "<div class=\"row g-3\">" +
                        "<div class=\"col-md-12\">" +
                        "	<h1>Past Reimbursements</h1>" +
                        "</div>" +
                        "<div class=\"col-md-12\">" +
                        "<table class=\"table table-bordered table-dark \">" +
                        "<tr>\n" +
                        "    <th>Ticket Number</th>\n" +
                        "    <th>Expense Detail</th>\n" +
                        "    <th>Amount</th>\n" +
                        "    <th>Date Start</th>\n" +
                        "    <th>Date End</th>\n" +
                        "    <th>Ticket Status</th>\n" +
                        "  </tr>");

        HttpSession httpSession = request.getSession();

        Employee employee = (Employee)httpSession.getAttribute("employee");

        List<Integer> statuses = new ArrayList<>();
        statuses.add(Reimbursement.hmap.get("APPROVED"));
        statuses.add(Reimbursement.hmap.get("DENIED"));

        List<Reimbursement> results = daoReimbursement.readByEmployeeTicketStatuses(employee.getEmployeeId(), statuses);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        /*java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);*/

        for (Reimbursement reimbursement : results) {
            httpSession.setAttribute("id", reimbursement.getTicketNumber());
            out.println("<tr>\n" +
                    "    <td>" + reimbursement.getTicketNumber()+ "</td>\n" +
                    "    <td>" + reimbursement.getExpenseDetail() + "</td>\n" +
                    "    <td>" + currencyFormat.format(reimbursement.getAmount())+ "</td>\n" +
                    "    <td>" + dateFormat.format(reimbursement.getDateStart()) + "</td>\n" +
                    "    <td>" + dateFormat.format(reimbursement.getDateEnd()) + "</td>\n" +
                    "    <td>" + Reimbursement.getStatusName(reimbursement.getTicketStatus()) + "</td>\n" +
                    "</tr>" );

        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");

        //request.getRequestDispatcher("footer.html").include(request, response);

    }

}

