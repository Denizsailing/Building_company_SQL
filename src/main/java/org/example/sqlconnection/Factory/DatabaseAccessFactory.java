package org.example.sqlconnection.Factory;

public interface DatabaseAccessFactory {
    MaterialDAO createMaterialDAO();
    SupplierDAO createSupplierDAO();
}
