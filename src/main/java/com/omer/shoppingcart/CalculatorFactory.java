package com.omer.shoppingcart;

public class CalculatorFactory {

    private ShoppingCart shoppingCart;

    public CalculatorFactory(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    //Returns calculator according to type parameter
    public ICalculator getCalculator(String calculatorType){

            if(calculatorType.equalsIgnoreCase("ShoppingPrice")){
                return new ShoppingPriceCalculator(this.shoppingCart);
            }
            else if(calculatorType.equalsIgnoreCase("DeliveryCost")){
                return new DeliveryCostCalculator(this.shoppingCart);
            }
            return null;

    }

}
