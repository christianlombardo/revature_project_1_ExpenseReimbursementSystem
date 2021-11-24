
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewFinancialManagerListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("FinanceNavbar.html").include(request, response);
        FinancialManagerDao financialManagerDao = FinancialManagerDaoFactory.getDaoFinancialManager();

        //request.getRequestDispatcher("header.html").include(request, response);

        List<FinancialManager> results = financialManagerDao.readAll();

        out.println("<div class=\"wrapper container\">" +
                "<div class=\"row g-3\">" +
                "<div class=\"col-md-12\">" +
                "	<h1>User Profile</h1>" +
                "</div>" +
                "<div class=\"col-md-12\">" +
                "<table class=\"table table-bordered table-dark \">" +
                "<tr>\n" +
                "    <th>id</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Username</th>\n" +
                "    <th>Gender</th>\n" +
                "  </tr>");

        HttpSession httpSession = request.getSession();
        for (FinancialManager financialManager : results) {
            httpSession.setAttribute("id", financialManager.getId());
            out.println(/*"<tr>\n" +
                    "    <td><a href=\"UpdateFinancialManagerServlet?employeeid=" + employee.getEmployeeId() +
                    "&name=" + employee.getName() + "&username=" + employee.getUsername() + "&gender=" + employee.getGender() +
                    "\" style=\"color: blue\">" + employee.getEmployeeId() + "</a></td>\n" +*/
                    "    <td>" + financialManager.getId() + "</td>\n" +
                            "    <td>" + financialManager.getName() + "</td>\n" +
                            "    <td>" + financialManager.getUsername() + "</td>\n" +
                            "    <td>" + financialManager.getGender() + "</td>\n" +
                    /*"    <td><a href=\"DeleteFinancialManagerServlet?userid=" + employee.getEmployeeId() +
                    "&name=" + employee.getName() + "&username=" + employee.getUsername() + "&gender=" + employee.getGender() +
                    "\" style=\"color: blue\">" +
                    "delete</a></td>\n" +*/
                            "</tr>" );
        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");

        request.getRequestDispatcher("footer.html").include(request, response);

    }
}
