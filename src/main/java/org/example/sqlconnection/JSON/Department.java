package org.example.sqlconnection.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class Department {
    @JsonProperty("department_id")
    private int departmentId;

    @JsonProperty("department_name")
    private String departmentName;

    @JsonProperty("customers")
    private List<Customer> customers;

    // Getter and setter methods

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}