import javax.persistence.*;


@Entity
public class Employee {

    @Id
    //@Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int employeeId;
    private String name;
    private String username;
    private String password;
    private String gender;


    public Employee() {}

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(int employeeId, String name, String username, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
