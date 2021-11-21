import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            request.getRequestDispatcher("test.html").include(request, response);
            employee = employeeDao.getEmployeeByUsernamePassword(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);
            out.println(
                    "<section class='vh-100 gradient-custom'>"+
                    "<div class='container py-5 h-100'>"+
                    "<div class='row d-flex justify-content-center align-items-center h-100'>"+
                    "<div class='col-12 col-md-9 col-lg-5 col-xl-5'>"+
                    "<div class='card bg-dark text-white style ='border-radius: 8rem;'>"+
                    "<div class='card-body p-5 text-center'>"+

                    "<div class='mb-md-5 mt-md-4 pb-5'>"+

                    "<h2 class='fw-bold mb-2 text'>Employee Reimbursement</h2>"+
                    "<p class='text-white-50 mb-5'></p>"+

                    "</div>"+

                    " <div> <p class='mb-0'>Financial Managers</p> </div>"+

                    "</div> </div> </div> </div> </div> </section> </form>");


            // view their past tickets and pending requests.


        } else {
            out.println("<please check you username and password.");
        }

        //out.println("username = " + username + " password = " + password);


    }
}
