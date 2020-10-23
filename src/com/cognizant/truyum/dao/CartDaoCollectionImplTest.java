
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;


public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		
		testAddCartItem();
		//testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() throws CartEmptyException {

		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.addCartItem(1, 000004);
		cartDao.addCartItem(1, 000001);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		System.out.println("MenuItem list :" + menuItemList);

	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemList;
		try {
			menuItemList = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			e.printStackTrace();
			return;
		}
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 000004);
		try {
			
			List<MenuItem> updatedmenuItem=cartDao.getAllCartItems(1);
			System.out.println(updatedmenuItem);
			
		} catch (CartEmptyException e) {
			System.out.println("Cart is empty");
		
		}
	}

}
