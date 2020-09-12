package com.omer.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryCostCalculatorTest {

    @Test
    void testCalculate() {
        Category category = new Category("test");
        Product product = new Product("test",20,category);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product,2);

        DeliveryCostCalculator calculator = new DeliveryCostCalculator(cart);
        calculator.setBaseDeliveryCost(10);
        double result = calculator.calculate();
        double expected = 20;
        assertEquals(expected, result);

    }
}