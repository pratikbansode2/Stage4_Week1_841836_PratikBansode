package com.cognizant.truyum.dao;


import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	public MenuItem getMenuItem(long menuItemId);

	public List<MenuItem> getMenuItemListCustomer();
	
	public void modifyMenuItem(MenuItem menuItem);

}
