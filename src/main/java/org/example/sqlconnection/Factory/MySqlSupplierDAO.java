package org.example.sqlconnection.Factory;

public class MySqlSupplierDAO implements SupplierDAO {
    private final DatabaseConnectionFactory connectionFactory;

    public MySqlSupplierDAO(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    // Implementation of methods in the SupplierDAO interface
}
