package com.omer.shoppingcart;

public class Coupon extends Discount{

    private double minCartAmount;

    public Coupon(double minCartAmount) {
        this.minCartAmount = minCartAmount;
    }

    public double getMinCartAmount() {
        return minCartAmount;
    }

    public void setMinCartAmount(double minCartAmount) {
        this.minCartAmount = minCartAmount;
    }

    //Applies coupon if shopping cart total price more than minimum cart amount
    public void applyCoupon(ShoppingCart shoppingCart){

        if(shoppingCart.getTotalPrice() >= minCartAmount){
            double discountedPrice =  shoppingCart.getTotalPrice() - shoppingCart.getTotalPrice() * this.getDiscountRate();
            shoppingCart.setTotalPrice(discountedPrice);
        }
    }
}
