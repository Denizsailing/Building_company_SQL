package org.example.sqlconnection;

import java.util.List;
public interface EmployeeService {
    Employee getEmployee(int employeeId);
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}