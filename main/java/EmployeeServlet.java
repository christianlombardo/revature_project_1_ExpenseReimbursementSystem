import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

        // employee login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee(username, password);

        if (employeeDao.login(employee)) {
            out.println("<h1>You have successfully logged in!</h1>");

            // submit requests for reimbursement
            employee = employeeDao.getEmployeeByUsernamePassword(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);
            out.println("<a href='EmployeeSubmitReimbursementServlet'>Request for Reimbursement</a>");


            out.println("<a href = >click here");

            // view their past tickets and pending requests.


        } else {
            out.println("<please check you username and password.");
        }

        //out.println("username = " + username + " password = " + password);


    }
}