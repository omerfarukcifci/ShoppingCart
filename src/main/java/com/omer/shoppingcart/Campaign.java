package com.omer.shoppingcart;

import java.util.List;


public class Campaign extends Discount {


    //Applies campaign to the specific product.
    public void applyCampaign(Product product){
        double discountedPrice = product.getPrice() - product.getPrice() * this.getDiscountRate();
         product.setDiscountedPrice(discountedPrice);
    }

    //Applies campaign to products that belong to a category
    public void applyCampaignToCategory(List<Product> products, Category category){

        for(int i = 0; i<products.size();i++){
            if(products.get(i).getCategory().equals(category)){
                double discountedPrice = products.get(i).getPrice() - products.get(i).getPrice() * this.getDiscountRate();
                products.get(i).setDiscountedPrice(discountedPrice);
            }
        }

    }
}
