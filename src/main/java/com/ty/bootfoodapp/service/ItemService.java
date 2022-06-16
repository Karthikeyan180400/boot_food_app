package com.ty.bootfoodapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.ItemDao;
import com.ty.bootfoodapp.dto.Foodorder;
import com.ty.bootfoodapp.dto.Item;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;

	public List<Item> saveItem(List<Item> items, Foodorder foodorder) {
		List<Item> items2 = new ArrayList<Item>();
		for (Item item : items) {
			item.setCost(item.getQuantity() * item.getMenu().getCost());
			items2.add(item);
		}
		return itemDao.saveItem(items2, foodorder);

	}

	public boolean deleteFoodorderItems(Foodorder foodorder) {
		return itemDao.deleteFoodorderItems(foodorder);

	}

}
