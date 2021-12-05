package com.company;

public class EssentialItem extends Item {
    public EssentialItem(int quantity, double price, String name, int quantityCap) {
        super.setQuantity(quantity);
        super.setPrice(price);
        super.setName(name);
        super.setCategory(Category.Essential);
        super.setQuantityCap(quantityCap);
    }
}
