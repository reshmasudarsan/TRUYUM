
package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	
	public static void main(String[] args) throws ParseException {
		System.out.println("only for admin");
		testGetMenuItemListAdmin();
		System.out.println("Only for customer");
		testGetMenuItemListCustomer();
		System.out.println("after modifying");
		testModifyMenuItem();

	}

	static void testGetMenuItemListAdmin() {

		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();

	

		List<MenuItem> menuItems = menuItemDaoCollectionImpl
				.getMenuItemListAdmin();

		for (MenuItem menuItem : menuItems) {

			System.out.println(menuItem.toString());

		}

	}

	static void testGetMenuItemListCustomer() {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItems = menuItemDaoCollectionImpl
				.getMenuItemListCustomer();

		for (MenuItem menuItem : menuItems) {

			System.out.println(menuItem.toString());

		}

	}

	static void testModifyMenuItem() throws ParseException {

		MenuItem menuItem = new MenuItem(000002, "Cake", 80.00f, true,
				DateUtil.convertToDate("11/12/2019"), "Main Course", false);
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified MenuItem details are :"
				+ menuItemDao.getMenuItem(000002));

	}

	void testGetMenuItem() {

	}

}
