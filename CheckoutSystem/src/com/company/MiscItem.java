package com.company;

public class MiscItem extends Item {
    public MiscItem(int quantity, double price, String name, int quantityCap) {
        super.setQuantity(quantity);
        super.setPrice(price);
        super.setName(name);
        super.setCategory(Category.Luxury);
        super.setQuantityCap(quantityCap);
    }
}
