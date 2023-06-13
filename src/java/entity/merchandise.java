/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author taote
 */
public class merchandise {
    private String id_mer;
    private String name_mer;

    public merchandise() {
    }

    public String getId_mer() {
        return id_mer;
    }

    public void setId_mer(String id_mer) {
        this.id_mer = id_mer;
    }

    public String getName_mer() {
        return name_mer;
    }

    public void setName_mer(String name_mer) {
        this.name_mer = name_mer;
    }

    public merchandise(String id_mer, String name_mer) {
        this.id_mer = id_mer;
        this.name_mer = name_mer;
    }

    @Override
    public String toString() {
        return "merchandise{" + "id_mer=" + id_mer + ", name_mer=" + name_mer + '}';
    }

    
    
}
