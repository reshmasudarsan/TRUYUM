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
            PreparedStatement stmt = con.prepareStatement("insert into cart ");
            // TODO to be competed
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {
        try {
            Connection con = ConnectionHandler.getConnection();
            Cart c = new Cart(new ArrayList<MenuItem>(), 0);
            PreparedStatement stmt = con.prepareStatement("select  ");
            //TODO to be complete
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                //TODO ////
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
            PreparedStatement stmt = con.prepareStatement("delete from cart where ");
            // TODO to be completed
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
