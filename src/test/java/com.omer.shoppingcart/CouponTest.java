package com.omer.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void testApplyCoupon() {
        ShoppingCart cart = new ShoppingCart();
        cart.setTotalPrice(500); // set cart total price 500

        Coupon coupon = new Coupon(1000); // new coupon created with 500 minimum cart amount
        coupon.setDiscountRate(0.25);
        coupon.applyCoupon(cart);

        double resultCouponNotApplied = cart.getTotalPrice();
        double expected = 500;
        assertEquals(expected,resultCouponNotApplied);

        cart.setTotalPrice(2000);
        coupon.applyCoupon(cart);

        double resultCouponApplied = cart.getTotalPrice();
        double expected2 = 1500;
        assertEquals(expected2,resultCouponApplied);

    }
}