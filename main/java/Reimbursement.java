import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;

@Entity
public class Reimbursement {

    //public enum TicketStatus {PENDING, APPROVED, DENIED} // pending (default)
    public static HashMap<String, Integer> hmap = new HashMap(3);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketNumber; // database id
    private String expenseDetail;
    private double amount;
    private Date dateStart;
    private Date dateEnd;
//    private String dateStart;
//    private String dateEnd;
    private Integer ticketStatus;
    private int employeeId;

    //@ManyToOne
    //@JoinColumn(name="EMPLOYEE_ID")
    //Employee employee;




    Reimbursement() {
        hmapTicketStatus();
    }

    Reimbursement(int ticketNumber, String expenseDetail, double amount, Date dateStart, Date dateEnd, Integer ticketStatus) {
        this.ticketNumber = ticketNumber;
        this.expenseDetail = expenseDetail;
        this.amount = amount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ticketStatus = ticketStatus;
        hmapTicketStatus();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getExpenseDetail() {
        return expenseDetail;
    }

    public void setExpenseDetail(String expenseDetail) {
        this.expenseDetail = expenseDetail;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

//    public Employee getEmployee() {
//        return employee;
//    }

//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public static String getStatusName(int statusNum) {

        String statusName="";
        switch (statusNum) {
            case 0:
                statusName = "PENDING";
                break;
            case 1:
                statusName = "APPROVED";
                break;
            case 2:
                statusName = "DENIED";
                break;
            default:
                break;
        }

        return statusName;

    }

    @Override
    public String toString() {
        return "detail =" + this.getExpenseDetail() + ", getAmount= " + this.getAmount() + ", getDateStart" + this.getDateStart() + ", getDateEnd" + this.getDateEnd() + ", getEmployeeId="; //+ this.employee.getEmployeeId();
    }

    public static void hmapTicketStatus() {
        hmap.put("PENDING", 0);
        hmap.put("APPROVED", 1);
        hmap.put("DENIED", 2);
    }

}
