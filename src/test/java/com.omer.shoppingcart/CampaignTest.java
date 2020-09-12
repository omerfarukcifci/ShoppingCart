package com.omer.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CampaignTest {

    @Test
    void testApplyCampaign() {
        Category category = new Category("test");
        Product product = new Product("test",100,category);
        Campaign campaign = new Campaign();
        campaign.setDiscountRate(0.3); // set %30 discount
        campaign.applyCampaign(product);

        double result = product.getDiscountedPrice();
        double expected = 70;
        assertEquals(expected, result);

    }

    @Test
    void testApplyCampaignToCategory() {
        Category category1 = new Category("test");
        Category category2 = new Category("test2");
        Product product1 = new Product("category1-product1",100,category1);
        Product product2 = new Product("category1-product2",100,category1);
        Product product3 = new Product("category2-product1",100,category2);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Campaign campaign = new Campaign();
        campaign.setDiscountRate(0.2); // set %20 discount
        campaign.applyCampaignToCategory(products,category1);

        double product1result = product1.getDiscountedPrice();
        double product1expected = 80;
        assertEquals(product1result, product1expected);

        double product2result = product2.getDiscountedPrice();
        double product2expected = 80;
        assertEquals(product2result, product2expected);

        double product3result = product3.getDiscountedPrice();
        double product3expected = 80;
        assertNotEquals(product3result, product3expected);

    }
}