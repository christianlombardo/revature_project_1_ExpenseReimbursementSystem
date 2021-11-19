<<<<<<< HEAD
=======

>>>>>>> 71d757a075768798ef5e3b259aaa1eddfb6d206b
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddEmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

<<<<<<< HEAD
        // request.getRequestDispatcher("header.html").include(request, response);
=======
       // request.getRequestDispatcher("header.html").include(request, response);
>>>>>>> 71d757a075768798ef5e3b259aaa1eddfb6d206b

        //int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee();
        //employee.setId(id);
        employee.setName(name);
        employee.setUsername(username);
        employee.setPassword(password);

        employeeDao.insert(employee);

        out.println("<div class=\"container h-100\"><h1>Recorded saved successfully.</h1></div>");

        //request.getRequestDispatcher("addemployee.html").include(request, response);
        //request.getRequestDispatcher("footer.html").include(request, response);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 71d757a075768798ef5e3b259aaa1eddfb6d206b
