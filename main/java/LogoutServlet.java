import org.hibernate.context.spi.CurrentSessionContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Employee employee = new Employee();
        HttpSession session = request.getSession();
        session.setAttribute("employee", employee);

        response.setContentType("text/html");
        request.getRequestDispatcher("EmployeeLogin.html").include(request, response);
    }
}
