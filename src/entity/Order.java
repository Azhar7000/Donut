/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Order {
    //method attributes
    private int ID;
    private String itemName;
    private String options;
    private int quantity;
    private double unitPrice;
    private double total;

    //constructor
    public Order(int ID, String itemName, String options, int quantity, double unitPrice, double total) {
        this.ID = ID;
        this.itemName = itemName;
        this.options = options;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
    }
     //getters for attributes
    public int getID() {
        return ID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getOptions() {
        return options;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotal() {
        return total;
    }
     //to string
    @Override
    public String toString() {
        return "Order{" + "ID=" + ID + ", itemName=" + itemName + ", total=" + total + '}';

    }
}
