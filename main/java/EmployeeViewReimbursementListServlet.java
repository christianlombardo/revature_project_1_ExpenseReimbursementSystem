
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeViewReimbursementListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

        request.getRequestDispatcher("header.html").include(request, response);

        List<Employee> results = employeeDao.readAll();

         out.println("<div class=\"container\">" +
                "<div class=\"row g-3\">" +
                "<div class=\"col-md-12\">" +
                "	<h1>User Profile</h1>" +
                "</div>" +
                "<div class=\"col-md-12\">" +
                "<table class=\"table w-auto table-dark table-responsive\" style=\"font-family:Arial;\">" +
                "<tr>\n" +
                "    <th>Name</th>\n" +
                "    <th>username</th>\n" +
                "    <th></th>\n" +
                "  </tr>");

        HttpSession httpSession = request.getSession();
        for (Employee employee : results) {
            httpSession.setAttribute("id", employee.getId());
            out.println("<tr>\n" +
                    "    <td><a href=\"UpdateEmployeeServlet?userid=" + employee.getId() +
                    "&name=" + employee.getName() + "&username=" + employee.getUsername()+
                    "\" style=\"color: blue\">" + employee.getId() + "</a></td>\n" +
                    "    <td>" + employee.getName() + "</td>\n" +
                    "    <td>" + employee.getUsername() + "</td>\n" +
                    "    <td>" + employee.getAmount() + "</td>\n"+
                    "    <td>" + employee.getDate() + "</td>\n"+
                    "    <td>" + employee.getTicketNumber() + "</td>\n"+
                    "    <td>" + employee.getTicketStatus() + "</td>\n"+
                    "</tr>" );
        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");

        request.getRequestDispatcher("footer.html").include(request, response);

    }
}
