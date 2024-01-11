package org.example.sqlconnection.Factory;

public class DiscountedMaterialPriceCalculator implements MaterialPriceCalculator {
    private final double discountPercentage;

    public DiscountedMaterialPriceCalculator(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(Material material) {
        double discountedPrice = material.getUnitPrice() * (1 - (discountPercentage / 100));
        return discountedPrice;
    }
}
