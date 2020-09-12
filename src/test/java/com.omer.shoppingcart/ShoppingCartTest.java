package com.omer.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testCalculateTotalPrice() {

        Category category = new Category("test");
        Product product = new Product("test",10,category);
        Product product2 = new Product("test2",20,category);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product,3); // Product price = 10 * 3 = 30
        cart.addProduct(product2,2); // Product price = 20 * 2 = 40

        /* Calculates delivery price and shopping price individually and adds them up.
        *  Products total price = 70 and
        *  delivery price = 2 (num of product) * 5 (total quantity) * 5(base delivery price) = 50
        *  So total price = 70 + 50 = 120
        * */
        double result = cart.calculateTotalPrice();
        double expected = 120;
        assertEquals(expected, result);

    }

}