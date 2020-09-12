package com.omer.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorFactoryTest {

    @Test
    void testGetCalculator() {
        ShoppingCart cart = new ShoppingCart();
        CalculatorFactory factory = new CalculatorFactory(cart);

        ICalculator shoppingPriceCalc = factory.getCalculator("ShoppingPrice");
        assertTrue(shoppingPriceCalc instanceof ShoppingPriceCalculator);

        ICalculator deliveryCostCalc = factory.getCalculator("DeliveryCost");
        assertTrue(deliveryCostCalc instanceof DeliveryCostCalculator);

    }
}