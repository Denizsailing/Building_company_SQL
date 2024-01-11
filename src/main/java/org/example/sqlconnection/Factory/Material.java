package org.example.sqlconnection.Factory;

public class Material {
    private int id;
    private String name;
    private double unitPrice;
    private int quantityInStock;

    public Material(int id, String name, double unitPrice, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
