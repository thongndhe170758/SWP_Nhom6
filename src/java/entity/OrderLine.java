/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author taote
 */
public class OrderLine {
    private int oid,pid;
    private int quatity;
    private double price;

    public OrderLine() {
    }

    public OrderLine(int oid, int pid, int quatity, double price) {
        this.oid = oid;
        this.pid = pid;
        this.quatity = quatity;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderLine{" + "oid=" + oid + ", pid=" + pid + ", quatity=" + quatity + ", price=" + price + '}';
    }
    
}
