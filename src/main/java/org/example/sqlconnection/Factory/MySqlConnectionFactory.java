package org.example.sqlconnection.Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory implements DatabaseConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/building_company";
    private static final String USERNAME = "denizsailing";
    private static final String PASSWORD = "Karabiga3517.";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
