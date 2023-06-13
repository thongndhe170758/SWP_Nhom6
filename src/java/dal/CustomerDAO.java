/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import java.sql.SQLException;

/**
 *
 * @author taote
 */
public class CustomerDAO extends MyDAO{
public Account getAccount(String email, String pass) {
        Account x = null;

        xSql = "select * from account where email=? and password=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                x = new Account(rs.getInt("idAccount"), pass, rs.getString("name"), email,rs.getString("role"));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public boolean addAccount(Account x) {
        String sql = "INSERT INTO account (password, name, email, role) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, x.getPassword());
            ps.setString(2, x.getName());
            ps.setString(3, x.getEmail());
            ps.setString(4, x.getRole());
            int rowsAffected = ps.executeUpdate();
            ps.close();

            return rowsAffected > 0; // Account added successfully
            // No rows were affected, account addition failed
        } catch (SQLException e) {
            e.printStackTrace();
            // Exception occurred, account addition failed
            return false;
        }
    }
}
