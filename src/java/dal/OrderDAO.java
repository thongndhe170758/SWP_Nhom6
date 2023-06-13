/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import entity.Cart;
import entity.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author taote
 */


public class OrderDAO extends MyDAO{
    public static void main(String[] args) {
        LocalDate curDate = java.time.LocalDate.now();
    String date = curDate.toString();
    Account ac = new Account();
       int i = ac.getIdAccount();
        System.out.println(i);
    }
            
   public void addOrder(Account ac, Cart cart) throws SQLException {
    LocalDate curDate = java.time.LocalDate.now();
    String date = curDate.toString();
    
    try {
        // Add to the "order" table
        String sql = "INSERT INTO `Order` (`date`, `cid`, `totalmoney`) VALUES (?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, date);
        st.setInt(2, ac.getIdAccount());
        st.setDouble(3, cart.getTotalMoney());
        st.executeUpdate();
        
        // Retrieve the ID of the last inserted order
        String sql1 = "SELECT id FROM `order` ORDER BY id DESC LIMIT 1";
        PreparedStatement st1 = con.prepareStatement(sql1);
        ResultSet rs = st1.executeQuery();
        
        if (rs.next()) {
            int oid = rs.getInt(1);
            
            // Insert order line items
            for (Item i : cart.getItem()) {
                String sql2 = "INSERT INTO orderline VALUES (?, ?, ?, ?)";
                PreparedStatement st2 = con.prepareStatement(sql2);
                st2.setInt(1, oid);
                st2.setInt(2, i.getProduct().getId());
                st2.setInt(3, i.getQuantity());
                st2.setDouble(4, i.getPrice());
                st2.executeUpdate();
            }
        }
        //update quantity of book
         String sql3 = "update  bookdetailed set quantity = quantity-? where book_id = ?";
          PreparedStatement st3 = con.prepareStatement(sql3);
          for (Item i : cart.getItem()) {
            st3.setInt(1, i.getQuantity());
            st3.setInt(2, i.getProduct().getId());
             st3.executeUpdate();
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
}
       
    

}
