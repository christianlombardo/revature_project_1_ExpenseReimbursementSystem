import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FinancialManagerLoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        FinancialManagerDao financialManagerDao = FinancialManagerDaoFactory.getDaoFinancialManager();

        // FinancialManager login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        FinancialManager financialManager = new FinancialManager(username, password);

        if (financialManagerDao.login(financialManager)) {

            financialManager = financialManagerDao.getFinancialManagerByUsernamePassword(username, password);

            HttpSession session = request.getSession();
            session.setAttribute("financialManager", financialManager);

            // view their past tickets and pending requests.
            request.getRequestDispatcher("test.html").include(request, response);
            response.sendRedirect("FinancialManagerServlet");

        } else {
            String message = "Please enter a valid username and password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/LoginFailManager.jsp").forward(request, response);
        }

    }

}
