import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FinancialManagerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int i= 1;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // see all pending reimbursements
        List<Employee> employees = new ArrayList<>();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Iterator iterator = reimbursements.iterator();
        out.println(
                        "<style>body{background-color:grey}</style>" +
                        "<header>head</head>" +
                        "<div class=\"container\"" +
                        "<div class=\"row g-3\">" +
                        "<div class=\"col-md-12\">" +
                        "<h1>User Profile</h1>" +
                        "</div>" +
                        "<div class=\"col-md-12\">" +
                        "<table class=\"table table-bordered table-dark table-responsive\" style=\"font-family:Arial;\">" +
                        "<tr>\n" +
                        "<th>ID</th>\n" +
                        "<th>Name</th>\n" +
                        "<th>Username</th>\n" +
                        "<th>Amount</th>\n" +
                        "<th>Date</th>\n" +
                        "<th>Ticket Number</th>\n" +
                        "<th>Ticket Status</th>\n" +
                        "</tr>");
        
          while(iterator.hasNext()){
                i++;
                //employee
                //employee infor
                if (reimbursements.get(i).getEmployeeId() == employees.get(i).getId()) {
                    out.println("<tr>\n" +
                            "<td>" + employees.get(i).getId() + "</td>\n" +
                            "<td>" + employees.get(i).getName() + "</td>\n" +
                            "<td>" + employees.get(i).getUsername() + "</td>\n" +
                            "<td>" + reimbursements.get(i).getAmount() + "</td>\n" +
                            "<td>" + reimbursements.get(i).getDateStart() + "</td>\n" +
                            "<td>" + reimbursements.get(i).getDateEnd() + "</td>\n" +
                            "<td>" + reimbursements.get(i).getTicketStatus() + "</td>\n" +
                            "</tr>");
                }
        }
        out.println("</table>" +
                "</div>" +
                "</div></div>");




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
