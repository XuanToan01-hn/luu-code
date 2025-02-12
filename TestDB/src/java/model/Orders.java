/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class Orders {
    private int orderID;
    private Date orderDate;
    private double total;
    private String userID;

    public Orders() {
    }

    public Orders(Date orderDate, double total, String userID) {
        this.orderDate = orderDate;
        this.total = total;
        this.userID = userID;
    }



    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", total=" + total + ", userID=" + userID + '}';
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
}
