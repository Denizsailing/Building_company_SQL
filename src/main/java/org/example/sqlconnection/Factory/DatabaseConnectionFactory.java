package org.example.sqlconnection.Factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionFactory {
    Connection getConnection() throws SQLException;
}
