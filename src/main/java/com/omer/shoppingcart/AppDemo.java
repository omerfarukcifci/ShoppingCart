package com.omer.shoppingcart;


import java.util.ArrayList;
import java.util.List;


/**
 * This class is used to demonstrate the program.
 */
public class AppDemo {

    private List<Product> products = new ArrayList<Product>();
    private List<Category> categories = new ArrayList<Category>();
    private ShoppingCart cart;

    public void testApplication(){
        cart = new ShoppingCart();
        createCategories();
        createProducts();
        addProductsToCart();

        cart.calculateTotalPrice();
        cart.print();

        Campaign campaign = new Campaign(); // create a new campaign.
        campaign.setDiscountRate(0.5); // %50 discount campaign created
        campaign.applyCampaign(products.get(2));

        System.out.println("\nAFTER CAMPAIGN APPLIED FOR TELEVISION WITH %50 DISCOUNT RATE: ");
        cart.calculateTotalPrice();
        cart.print();

        campaign.applyCampaignToCategory(products,categories.get(0));

        System.out.println("\nAFTER CAMPAIGN APPLIED FOR FOOD CATEGORY WITH %50 DISCOUNT RATE: ");
        cart.calculateTotalPrice();
        cart.print();

        /*Create a coupon with minimum cart amount 1000. Coupon applies for
         shopping cart with a quantity of at least 1000. */
        Coupon coupon = new Coupon(1000);
        coupon.setDiscountRate(0.25); // Set %25 discount for coupon
        coupon.applyCoupon(cart);

        System.out.println("\nAFTER COUPON APPLIED WITH %25 DISCOUNT RATE : ");
        cart.print();
    }

    public void addProductsToCart(){
        for (int i=0;i<products.size();i++){
            cart.addProduct(products.get(i),2);
        }
    }

    public void createProducts(){
        products.add(new Product("Apple",10,categories.get(0)));
        products.add(new Product("Almond",30,categories.get(0)));
        products.add(new Product("Television",3000,categories.get(1)));
        products.add(new Product("Playstation",4000,categories.get(1)));
        products.add(new Product("Skin Care Cream",50,categories.get(2)));
        products.add(new Product("Guitar",500,categories.get(3)));

    }

    public void createCategories(){
        categories.add(new Category("food"));
        categories.add(new Category("electronics"));
        categories.add(new Category("personel care"));
        categories.add(new Category("hobby"));
    }

}
