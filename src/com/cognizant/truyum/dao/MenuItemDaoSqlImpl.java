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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
                    .prepareStatement("select * from menu_item where is_active=? and date_of_launch>=?");
            stmt.setString(1, "active");
            Date dateobj = new Date(0);
            stmt.setDate(2, dateobj);
            ResultSet rst = stmt.executeQuery();

            while (rst.next()) {
                m.add(new MenuItem(rst.getLong(1), rst.getString(2), rst.getFloat(3), rst.getBoolean(4), rst.getDate(5),
                        rst.getString(6), rst.getBoolean(7)));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem) {
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con
                    .prepareStatement("update menu_item where item_id=? set item_name=?,set ");
            stmt.setLong(1, menuItem.getId());
            /////
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public MenuItem getMenuItem(long menuitemId) {
        try {
            Connection con = ConnectionHandler.getConnection();
            PreparedStatement stmt = con
                    .prepareStatement("select * from menu_item where item_id=?");
            stmt.setLong(1, menuitemId);
            ResultSet rst = stmt.executeQuery();

            while (rst.next()) {
                return new MenuItem(rst.getLong(1), rst.getString(2), rst.getFloat(3), rst.getBoolean(4), rst.getDate(5),rst.getString(6), rst.getBoolean(7));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
