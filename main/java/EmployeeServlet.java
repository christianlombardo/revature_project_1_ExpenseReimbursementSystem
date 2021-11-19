import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        } else {
<<<<<<< HEAD
            out.println("<please check you username and password.");
        }


        //out.println("username = " + username + " password = " + password);

        // submit requests for reimbursement
        out.println("<a href = >click here");

        // view their past tickets and pending requests.


    }
}
=======
            out.println("<p>please check you username and password.</p>");
        }

        //out.println("username = " + username + " password = " + password);

        // Go to Employee Page Home Page
            // submit requests for reimbursement
                // EmployeeSubmitReimbursementServlet
            // view their pending requests.
            // view their past tickets.


    }
}
>>>>>>> 71d757a075768798ef5e3b259aaa1eddfb6d206b
