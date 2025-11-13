/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * Oaks donut shop MenuItem entity
 */
public class MenuItem
{
    private int ID;
    private String name;
    private String category;
    private double unitPrice;

    public MenuItem(int ID, String name, String category, double unitPrice)
    {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {return unitPrice;}

    @Override
    public String toString() {
        return "MenuItem{" + "ID=" + ID + ", Name=" + name + ", category=" + category + ", unitPrice=" + unitPrice + '}';
    }
}
