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

        // request.getRequestDispatcher("header.html").include(request, response);
        // request.getRequestDispatcher("header.html").include(request, response);

        //int id = Integer.parseInt(request.getParameter("id"));
        // http://localhost:8081/project1/UpdateStatusServlet?
        // reimbursementId=46
        // &status=1
        // &expenseDetail=Another%20exciting%20trip
        // &amount=333.0
        // &dateStart=0184-05-11
        // &dateEnd=0184-05-11
        int reimbursementId = Integer.parseInt(request.getParameter("reimbursementId"));
        int status = Integer.parseInt(request.getParameter("status"));
        String expenseDetail = request.getParameter("expenseDetail");
        double amount = Double.parseDouble(request.getParameter("amount"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Date dateStart;
        Date dateEnd;
        Reimbursement reimbursement = new Reimbursement();
        try {
            dateStart = java.text.DateFormat.getDateInstance().parse(request.getParameter("dateStart"));
            dateEnd = java.text.DateFormat.getDateInstance().parse(request.getParameter("dateEnd"));
            reimbursement.setDateStart(dateStart);
            reimbursement.setDateEnd(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        reimbursement.setTicketNumber(reimbursementId);
        reimbursement.setExpenseDetail(expenseDetail);
        reimbursement.setTicketStatus(status);
        reimbursement.setAmount(amount);
        reimbursement.setEmployeeId(employeeId);
        daoReimbursement.update(reimbursement);

        out.println("<div class=\"container h-100\"><h1>Recorded updated successfully.</h1></div>");

        //request.getRequestDispatcher("addemployee.html").include(request, response);
        //request.getRequestDispatcher("footer.html").include(request, response);

    }
}
