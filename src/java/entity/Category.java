/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author taote
 */
public class Category {
  
    private int idCate;
    private String catName;
    private int idMerch;
    public Category() {
    }

    public Category(int idCate, String catName, int idMerch) {
        this.idCate = idCate;
        this.catName = catName;
        this.idMerch = idMerch;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getIdMerch() {
        return idMerch;
    }

    public void setIdMerch(int idMerch) {
        this.idMerch = idMerch;
    }

    @Override
    public String toString() {
        return "Category{" + "idCate=" + idCate + ", catName=" + catName + ", idMerch=" + idMerch + '}';
    }

 
   
    
}
