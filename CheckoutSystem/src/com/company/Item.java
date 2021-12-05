package com.company;

public class Item {
    private Category category;
    private int quantity;
    private double price;
    private int quantityCap;
    private String name;

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantityCap(int quantityCap) { this.quantityCap = quantityCap; }
    public int getQuantityCap() { return quantityCap; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
