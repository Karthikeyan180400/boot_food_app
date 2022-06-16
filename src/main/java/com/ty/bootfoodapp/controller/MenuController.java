package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Menu;
import com.ty.bootfoodapp.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	MenuService menuService;

	@PostMapping("/menus")
	public Menu saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);

	}

	@GetMapping("/menus/{id}")
	public Menu getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);

	}

	@GetMapping("/menus")
	public List<Menu> getAllMenu() {
		return menuService.getAllMenu();

	}

	@PutMapping("/menus")
	public Menu updateMenu(@RequestBody Menu menu, @RequestParam int id) {
		return menuService.updateMenu(menu, id);

	}

	@DeleteMapping("/menus/{id}")
	public String deleteMenu(@PathVariable int id) {
		boolean res = menuService.deleteMenu(id);
		if (res) {
			return "Deleted";
		} else {
			return "Not Deleted";
		}

	}

}
