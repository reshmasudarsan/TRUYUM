package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

    @Override
    public List<MenuItem> getMenuItemListAdmin() {
        ArrayList<MenuItem> m = new ArrayList<>();
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from menu_item");
            ResultSet rst = stmt.executeQuery();

            while (rst.next()) {
                m.add(new MenuItem(rst.getLong(1), rst.getString(2), rst.getFloat(3), rst.getBoolean(4), rst.getDate(5),
                        rst.getString(6), rst.getBoolean(7)));
            }
        } catch (ClassNotFoundException e) {
        
            e.printStackTrace();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<MenuItem> getMenuItemListCustomer() {
        ArrayList<MenuItem> m = new ArrayList<>();
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con
                    .prepareStatement("select * from menu_item where active=? and date_of_launch>=?");
            stmt.setString(1, "true");
            Date dateobj = new Date(0);
            stmt.setDate(2, dateobj);
            ResultSet rst = stmt.executeQuery();

            while (rst.next()) {
                m.add(new MenuItem(rst.getLong(1), rst.getString(2), rst.getFloat(3), rst.getBoolean(4), rst.getDate(5),
                        rst.getString(6), rst.getBoolean(7)));
            }
        } catch (ClassNotFoundException e) {
        
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem) {
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con
                    .prepareStatement("update menu_item where id=? set item_name=?,set price=?,set active=?,set date_of_launch=?,set category=?,set free_delivery=?");
            stmt.setLong(1, menuItem.getId());
            stmt.setString(2, menuItem.getName());
            stmt.setFloat(3, menuItem.getPrice());
            stmt.setBoolean(4, menuItem.isActive());
            stmt.setDate(5, menuItem.getDateOfLaunch());
            stmt.setString(6, menuItem.getCategory());
            stmt.setBoolean(7, menuItem.isFreeDelivery());
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    @Override
    public MenuItem getMenuItem(long menuitemId) {
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con
                    .prepareStatement("select * from menu_item where id=?");
            stmt.setLong(1, menuitemId);
            ResultSet rst = stmt.executeQuery();

            while (rst.next()) {
                return new MenuItem(rst.getLong(1), rst.getString(2), rst.getFloat(3), rst.getBoolean(4), rst.getDate(5),rst.getString(6), rst.getBoolean(7));
            }
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
    }

}
