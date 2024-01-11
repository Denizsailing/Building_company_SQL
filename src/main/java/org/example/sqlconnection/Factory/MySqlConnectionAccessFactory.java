package org.example.sqlconnection.Factory;

public class MySqlConnectionAccessFactory implements DatabaseAccessFactory {
    private final DatabaseConnectionFactory connectionFactory;

    public MySqlConnectionAccessFactory(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public MaterialDAO createMaterialDAO() {
        return new MySqlMaterialDAO(connectionFactory);
    }

    @Override
    public SupplierDAO createSupplierDAO() {
        return new MySqlSupplierDAO(connectionFactory);
    }
}
