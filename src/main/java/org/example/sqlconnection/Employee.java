package org.example.sqlconnection;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlElement(name = "employeeId")
    private int employeeId;

    @XmlElement(name = "firstName")
    private String firstName;

    @XmlElement(name = "lastName")
    private String lastName;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "phone")
    private String phone;

    @XmlElement(name = "hireDate")
    private Date hireDate;

    @XmlElement(name = "salary")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal salary;

    @XmlElement(name = "jobTitle")
    private String jobTitle;

    @XmlElement(name = "departmentId")
    private int departmentId;

    @XmlElement(name = "managerId")
    private int managerId;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    // BigDecimalAdapter classı buraya gelecek
    public static class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {
        @Override
        public BigDecimal unmarshal(String value) throws Exception {
            return new BigDecimal(value);
        }

        @Override
        public String marshal(BigDecimal value) throws Exception {
            return value.toString();
        }
    }
}
