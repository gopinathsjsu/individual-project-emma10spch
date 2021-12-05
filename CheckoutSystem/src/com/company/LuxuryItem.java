package com.company;

public class LuxuryItem extends Item {
    static int categoryCap = 0;
    public LuxuryItem(int quantity, double price, String name, int quantityCap) {
        super.setQuantity(quantity);
        super.setPrice(price);
        super.setName(name);
        super.setCategory(Category.Luxury);
        super.setQuantityCap(quantityCap);
    }
}
