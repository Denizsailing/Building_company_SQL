package org.example.sqlconnection.Factory;

public class MaterialBuilder {
    private int id;
    private String name;
    private double unitPrice;
    private int quantityInStock;

    public MaterialBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MaterialBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MaterialBuilder setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }
    public MaterialBuilder setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
        return this;
    }

    public Material build() {
        return new Material(id, name, unitPrice, quantityInStock);
    }
}


