package com.keyin.example;

public class InventoryItem {
    // Declare private variables
    private String name;
    private int quantity;
    private double price;

    // Default constructor
    public InventoryItem() {
        this.name = "";
        this.quantity = 0;
        this.price = 0;
    }

    // Constuctor with args name, quantity and price
    public InventoryItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
