/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author taote
 */
public class Order {
    private int id;
    private String date;
    private int cuid;
    private double totalMoney;

    public Order() {
    }

    public Order(int id, String date, int cuid, double totalMoney) {
        this.id = id;
        this.date = date;
        this.cuid = cuid;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCuid() {
        return cuid;
    }

    public void setCuid(int cuid) {
        this.cuid = cuid;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", cuid=" + cuid + ", totalMoney=" + totalMoney + '}';
    }
    
}
