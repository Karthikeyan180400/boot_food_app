package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Menu;
import com.ty.bootfoodapp.repository.MenuRepository;

@Repository
public class MenuDao {

	@Autowired
	MenuRepository menuRepository;

	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu getMenuById(int id) {
		Optional<Menu> optional = menuRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	public List<Menu> getAllMenu() {
		return menuRepository.findAll();

	}

	public Menu updateMenu(Menu menu, int id) {
		Optional<Menu> optional = menuRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return menuRepository.save(menu);
		}

	}

	public boolean deleteMenu(int id) {
		Optional<Menu> optional = menuRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			menuRepository.delete(optional.get());
			return true;
		}

	}

}
