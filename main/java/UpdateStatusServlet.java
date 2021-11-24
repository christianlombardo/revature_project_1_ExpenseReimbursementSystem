import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

public class UpdateStatusServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ReimbursementDao daoReimbursement = ReimbursementDaoFactory.getReimbursementDao();

        int reimbursementId = Integer.parseInt(request.getParameter("reimbursementId"));
        int status = Integer.parseInt(request.getParameter("status"));
        String expenseDetail = request.getParameter("expenseDetail");
        double amount = Double.parseDouble(request.getParameter("amount"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");
        Reimbursement reimbursement = new Reimbursement();

        reimbursement.setTicketNumber(reimbursementId);
        reimbursement.setExpenseDetail(expenseDetail);
        reimbursement.setTicketStatus(status);
        reimbursement.setAmount(amount);
        reimbursement.setEmployeeId(employeeId);
        reimbursement.setDateStart(dateStart);
        reimbursement.setDateEnd(dateEnd);
        daoReimbursement.update(reimbursement);

        out.println("<div class=\"container h-100\"><h1>Recorded updated successfully.</h1></div>");

        response.sendRedirect("FinancialManagerServlet");

        //request.getRequestDispatcher("footer.html").include(request, response);

    }

}
