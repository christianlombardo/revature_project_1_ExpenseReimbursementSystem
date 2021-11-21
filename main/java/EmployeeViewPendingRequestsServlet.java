import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeViewPendingRequestsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ReimbursementDao daoReimbursement = ReimbursementDaoFactory.getEmployeeDao();

         out.println(
                "<ul class=\"nav nav-tabs\"navbar-fixed-top sticky>\n" +
                        "  <li class=\"nav-item\">\n" +
                        "    <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\n" +
                        "  </li>\n" +
                        "  <li class=\"nav-item\">\n" +
                        "    <a class=\"nav-link\" href=\"#\">Submit</a>\n" +
                        "  </li>\n" +
                        "  <li class=\"nav-item\">\n" +
                        "    <a class=\"nav-link\" href=\"#\">View all current reimbursements</a>\n" +
                        "  </li>\n" +
                        "  <li class=\"nav-item\">\n" +
                        "    <a class=\"nav-link\" href=\"#\">View all past reimbursements</a>\n" +
                        "  </li>\n" +
                        "</ul>" +
                "<style>body{background-color:grey}</style>" +
                "<header>head</head>" +
                "<div class=\"container\"" +
                "<div class=\"row g-3\">" +
                "<div class=\"col-md-12\">" +
                "	<h1>User Profile</h1>" +
                "</div>" +
                "<div class=\"col-md-12\">" +
                "<table class=\"table table-bordered table-dark table-responsive\" style=\"font-family:Arial;\">" +
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

        List<Reimbursement> reimbursements = daoReimbursement.readByEmployeeTicketStatus(employee.getId(), Reimbursement.hmap.get("PENDING"));

        for (Reimbursement reimbursement : reimbursements) {
            //httpSession.setAttribute("id", reimbursement.getTicketNumber());
            out.println("<tr>\n" +
                    "    <td>" + reimbursement.getTicketNumber()+ "</td>\n" +
                    "    <td>" + reimbursement.getExpenseDetail() + "</td>\n" +
                    "    <td>" + reimbursement.getAmount()+ "</td>\n" +
                    "    <td>" + reimbursement.getDateStart() + "</td>\n" +
                    "    <td>" + reimbursement.getDateEnd() + "</td>\n" +
                    "    <td>" + reimbursement.getTicketStatus() + "</td>\n" +
                    "</tr>" );

        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");

        //request.getRequestDispatcher("footer.html").include(request, response);

    }
}
