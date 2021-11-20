import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeViewPendingRequestsServlet extends HttpServlet {

    public void doPost (HttpServletRequest request, HttpServletResponse reponse) {
        
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
                "    <th>ID</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Username</th>\n" +
                "  </tr>");

        HttpSession httpSession = request.getSession();
        for (Employee employees : results) {
            httpSession.setAttribute("id", employees.getId());
            out.println("<tr>\n" +
                    "    <td>" + employees.getId()+ "</td>\n" +
                    "    <td>" + employees.getName() + "</td>\n" +
                    "    <td>" + employees.getUsername() + "</td>\n" +
                    "</tr>" );

        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");

        request.getRequestDispatcher("footer.html").include(request, response);

    }
}
