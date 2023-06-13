/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {
    private Integer idAccount;
    private String password;
    private String name;
    private String email;
    private String role;

    public Account() {
    }

    public Account(Integer idAccount, String password, String name, String email, String role) {
        this.idAccount = idAccount;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role=role;
   }
      public Account(String password, String name, String email, String role) {
        this.idAccount = null;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role=role;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
      
    

    

    @Override
    public String toString() {
        return "email: "+email+"name: "+name+"password: "+password; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
 
    
}