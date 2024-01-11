package org.example.sqlconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Connection connection = MySQLConnection.getConnection();

        try {
            // database  process
            insertData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, phone, hire_date, salary, job_title, department_id, manager_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 21231230);
            statement.setString(2, "deniz");
            statement.setString(3, "gunduz");
            statement.setString(4, "mailmail");
            statement.setString(5, "1231321");
            statement.setString(6, "2023-06-09");
            statement.setBigDecimal(7, new BigDecimal("60000.00"));
            statement.setString(8, "tester");
            statement.setInt(9, 2);
            statement.setInt(10, 1);

            statement.executeUpdate();
        }

        System.out.println("Data inserted into employees table.");
    }
}
