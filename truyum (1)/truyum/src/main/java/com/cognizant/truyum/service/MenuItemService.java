package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	@Autowired
	MenuItemDao menuItemDao;
	
	public MenuItem getMenuItem(long id)
	{
		return menuItemDao.getMenuItem(id);
	}
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		return menuItemDao.getMenuItemListCustomer();
	}

	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
		
	}
}
