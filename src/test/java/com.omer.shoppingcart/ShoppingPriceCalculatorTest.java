package com.omer.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingPriceCalculatorTest {

    @Test
    void testCalculate() {
        Category category = new Category("test");
        Product product = new Product("test",10,category);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product,3);

        ShoppingPriceCalculator calculator = new ShoppingPriceCalculator(cart);
        double result = calculator.calculate();
        double expected = 30;
        assertEquals(expected, result);
    }
}