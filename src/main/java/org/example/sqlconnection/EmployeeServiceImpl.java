package org.example.sqlconnection;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }



    @Override
    public Employee getEmployee(int id) {

        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeDAO.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeDAO.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

        employeeDAO.update(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {

        employeeDAO.delete(employee);
    }


}
