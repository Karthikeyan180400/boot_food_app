package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.MenuDao;
import com.ty.bootfoodapp.dto.Menu;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;

	public Menu saveMenu(Menu menu) {
		return menuDao.saveMenu(menu);
	}

	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);

	}

	public List<Menu> getAllMenu() {
		return menuDao.getAllMenu();

	}

	public Menu updateMenu(Menu menu, int id) {
		return menuDao.updateMenu(menu, id);

	}

	public boolean deleteMenu(int id) {
		return menuDao.deleteMenu(id);

	}

}
