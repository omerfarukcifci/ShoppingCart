package com.omer.shoppingcart;

import java.util.Map;

public class ShoppingPriceCalculator implements ICalculator{

    private ShoppingCart shoppingCart;

    public ShoppingPriceCalculator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getCart() {
        return shoppingCart;
    }

    public void setCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public double calculate() {
        double cartTotalPrice= 0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {
            Product product = entry.getKey();
            double quantity = entry.getValue();
            cartTotalPrice += product.getDiscountedPrice() * quantity;
        }
        return cartTotalPrice;
    }
}
