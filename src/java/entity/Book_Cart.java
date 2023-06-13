/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author taote
 */
public class Book_Cart {
    private int id;
    private String name;
    private String image;
    private int quantity;
    private double price;

    public Book_Cart() {
    }

    public Book_Cart(int id, String name, String image, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book_Cart{" + "id=" + id + ", name=" + name + ", image=" + image + ", quantity=" + quantity + ", price=" + price + '}';
    }

    
    
}
