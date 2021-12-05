package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CheckoutSystem cs = new CheckoutSystem();
        cs.loadDB();
        cs.processOrder();
    }
}
