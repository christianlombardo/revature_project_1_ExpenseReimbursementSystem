import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FinancialManagerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // see all pending reimbursements
        List<Employee> employees = new ArrayList<>();
        List<Reimbursement> reimbursements = new ArrayList<>();


        for (int i=0 ; i<employees.size() ; i++) {
            Employee employee = employees.get(i);
            Reimbursement reimbursement = reimbursements.get(i);
            // html/css/bootstrap
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get all Employees out in a LIST
        // get all Reimbursement put in a LIST
        //
        List<Employee> employees = new ArrayList<>();
        List<Reimbursement> reimbursements = new ArrayList<>();


        for (int i=0 ; i<employees.size() ; i++) {
            Employee employee = employees.get(i);
            Reimbursement reimbursement = reimbursements.get(i);
            // html/css/bootstrap
        }




    }


}
