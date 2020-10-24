package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

    @Override
    public void addCartItem(long userid, long menuItemId) {
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into cart(ct_user_id, ct_menu_id) values (?, ?)");
            stmt.setLong(1, userid);
            stmt.setLong(2, menuItemId);

            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {
        double totalprice = 0;
        try {
            Connection con = ConnectionHandler.getConnection();
            Cart c = new Cart(new ArrayList<MenuItem>(), 0);
            PreparedStatement stmt = con.prepareStatement("select * from menu_item WHERE id IN (select ct_menu_id from cart where ct_user_id = ?)");
            stmt.setLong(1, userid)
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                long id = rs.getLong(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                totalprice += price;
                boolean active = rs.getInt(4)==1;
                Date dateOfLaunch = rs.getDate(5);
                String category = rs.getString(6);
                boolean freeDelivery = rs.getInt(7)==1;
                MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
                menuItemList.add(menuItem);
            }
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeCartItem(long userId, long menuitemid) {
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from cart where ct_menu_id = ? AND ct_user_id = ?");
               stmt.setLong(1, menuitemid);
               stmt.setLong(2, userId);


            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
