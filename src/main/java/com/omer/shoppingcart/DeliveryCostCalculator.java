package com.omer.shoppingcart;

import java.util.Map;

public class DeliveryCostCalculator implements ICalculator {

    private ShoppingCart shoppingCart;
    private double baseDeliveryCost = 5.0;

    public DeliveryCostCalculator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getBaseDeliveryCost() {
        return baseDeliveryCost;
    }

    public void setBaseDeliveryCost(double baseDeliveryCost) {
        this.baseDeliveryCost = baseDeliveryCost;
    }

    @Override
    public double calculate() {
        int numOfProducts = shoppingCart.getProducts().size();
        double quantityOfProduct = 0;

        for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {
            quantityOfProduct += entry.getValue();
        }

        double totalDeliveryCost = quantityOfProduct * numOfProducts * baseDeliveryCost;
        return totalDeliveryCost;
    }
}
