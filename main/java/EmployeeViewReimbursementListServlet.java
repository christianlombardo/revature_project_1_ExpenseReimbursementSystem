
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
                "<table class=\"table w-auto table-primary table-responsive\" style=\"font-family:Verdana;\">" +
                "<tr>\n" +
                "    <th>id</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Email</th>\n" +
                "    <th>Country</th>\n" +
                "    <th>Gender</th>\n" +
                "    <th></th>\n" +
                "  </tr>");

        HttpSession httpSession = request.getSession();
        for (Employee employee : results) {
            httpSession.setAttribute("id", employee.getId());
            out.println("<tr>\n" +
                    "    <td><a href=\"UpdateEmployeeServlet?userid=" + employee.getId() +
                    "&name=" + employee.getName() + "&username=" + employee.getUsername() + "&password=" + employee.getPassword() +
                    "\" style=\"color: blue\">" + employee.getId() + "</a></td>\n" +
                    "    <td>" + employee.getName() + "</td>\n" +
                    "    <td>" + employee.getUsername() + "</td>\n" +
                    "    <td>" + employee.getPassword() + "</td>\n" +
                    "</tr>" );
        }
        out.println("</table>" +
                        "</div>" +
                        "</div></div>");

        request.getRequestDispatcher("footer.html").include(request, response);

    }
}
