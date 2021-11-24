import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddFinancialManagerServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        FinancialManagerDao financialManagerDao= FinancialManagerDaoFactory.getDaoFinancialManager();

        // request.getRequestDispatcher("header.html").include(request, response);
       // request.getRequestDispatcher("header.html").include(request, response);

        //int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        FinancialManager financialManager = new FinancialManager();
        //employee.setId(id);
        financialManager.setName(name);
        financialManager.setUsername(username);
        financialManager.setPassword(password);
        financialManager.setGender(gender);

        financialManagerDao.insert(financialManager);

        out.println("<div class=\"container h-100\"><h1>Recorded saved successfully.</h1></div>");

        //response.sendRedirect("FinancialManagerServlet");
        response.sendRedirect("ViewEmployeeListServlet");

        //request.getRequestDispatcher("addemployee.html").include(request, response);
        //request.getRequestDispatcher("footer.html").include(request, response);
    }

}
