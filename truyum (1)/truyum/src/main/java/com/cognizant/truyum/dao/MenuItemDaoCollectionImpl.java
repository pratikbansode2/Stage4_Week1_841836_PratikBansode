package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);

	private static List<MenuItem> listOfMenuItem;

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		listOfMenuItem=getMenuItemListCustomer();
		LOGGER.debug("MenuItemList: {} ",listOfMenuItem);
		return listOfMenuItem.stream().filter(item->(item.getId()==menuItemId )).findFirst().orElseThrow(() -> {throw new MenuItemNotFoundException();});
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
     	List<MenuItem> menuItemListCustomer = context.getBean("menuItemList", ArrayList.class);
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
				LOGGER.debug("START");
				LOGGER.info(menuItem.toString());
		
	}

}
