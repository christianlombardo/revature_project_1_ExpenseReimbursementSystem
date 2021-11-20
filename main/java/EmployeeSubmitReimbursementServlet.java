import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeSubmitReimbursementServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //request.getRequestDispatcher("navbar.html").include(request, response);

        // get employee object from the session
        HttpSession session = request.getSession(false); // true to create a new session for this request if necessary; false to return null if there's no current session https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html#getSession(boolean)
        Employee employee = (Employee)session.getAttribute("employee");

        out.println("id = " + employee.getId() + "username = " + employee.getUsername() + " password = " + employee.getPassword() + "");

        // submit request to add in the reimbursement table in the database.


        // Expense Detail(Text Field)
        // Amount
        // Date Start
        // Date End
        // TicketNumber() // databse id
        // TicketStatus() pending (default)


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        // Reimbursement resimb=- new Reinburse();

    }

}
