package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.MenuItem;
import java.util.List;

public interface CartDao {
	
	public void addCartItem(long userid , long menuItemId);
	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException;
	public void removeCartItem(long userId,long menuitemid);
	

}
