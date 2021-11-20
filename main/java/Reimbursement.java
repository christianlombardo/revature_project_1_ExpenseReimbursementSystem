import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reimbursement {

    public enum TicketStatus {PENDING, APPROVED, DENIED} // pending (default)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketNumber; // database id
    private String expenseDetail;
    private double amount;
    private Date dateStart;
    private Date dateEnd;
    private TicketStatus ticketStatus;
    private int employeeId;

    Reimbursement() {}

    Reimbursement(int ticketNumber, String expenseDetail, double amount, Date dateStart, Date dateEnd, TicketStatus ticketStatus) {
        this.ticketNumber = ticketNumber;
        this.expenseDetail = expenseDetail;
        this.amount = amount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ticketStatus = ticketStatus;
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

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "detail =" + this.getExpenseDetail() + ", getAmount= " + this.getAmount() + ", getDateStart" + this.getDateStart() + ", getDateEnd" + this.getDateEnd() + ", getEmployeeId=" + this.getEmployeeId();
    }

}
