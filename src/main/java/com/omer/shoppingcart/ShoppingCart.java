package com.omer.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Product,Integer> products;
    private CalculatorFactory calculatorFactory;
    private double totalPrice;

    public ShoppingCart() {
        this.products = new HashMap<Product,Integer>();
        this.calculatorFactory = new CalculatorFactory(this);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public CalculatorFactory getCalculatorFactory() {
        return calculatorFactory;
    }

    public void setCalculatorFactory(CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //Add product to the shopping cart.
    public void addProduct(Product product, int quantity){
        products.put(product,quantity);
    }

    //Removes product from the shopping cart.
    public void removeProduct(Product product){
        products.remove(product);
    }


    // Calculates total price of the cart by using two different calculator.
    public double calculateTotalPrice(){
        //calculatorFactory.setShoppingCart(this);
        ICalculator shoppingPriceCalc = calculatorFactory.getCalculator("ShoppingPrice");
        ICalculator deliveryCostCalc = calculatorFactory.getCalculator("DeliveryCost");

        totalPrice =  shoppingPriceCalc.calculate() + deliveryCostCalc.calculate();
        return totalPrice;
    }

    // Prints the last status of the cart
    public void print(){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            double quantity = entry.getValue();

            System.out.println("Product Name: "+product.getTitle() + "\t\t\t\tProduct Price: "+ product.getDiscountedPrice() +"\t\t\t\tQuantity: "+quantity);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Cart Total Price: "+ totalPrice);
    }


}
