package org.example.sqlconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends AbstractDAO<Employee> {
    public EmployeeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM Employee WHERE employee_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setHireDate(resultSet.getDate("hire_date"));
                employee.setSalary(resultSet.getBigDecimal("salary"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                employee.setManagerId(resultSet.getInt("manager_id"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setHireDate(resultSet.getDate("hire_date"));
                employee.setSalary(resultSet.getBigDecimal("salary"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                employee.setManagerId(resultSet.getInt("manager_id"));

                employees.add(employee);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public void save(Employee entity) {
        String sql = "INSERT INTO Employee (employee_id, first_name, last_name, email, phone, hire_date, salary, job_title, department_id, manager_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getEmployeeId());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getPhone());
            statement.setDate(6, new java.sql.Date(entity.getHireDate().getTime()));
            statement.setBigDecimal(7, entity.getSalary());
            statement.setString(8, entity.getJobTitle());
            statement.setInt(9, entity.getDepartmentId());
            statement.setInt(10, entity.getManagerId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee entity) {
        // Implementation for update method
    }

    @Override
    public void delete(Employee entity) {
        // Implementation for delete method
    }
}
