package com.ty.bootfoodapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Foodorder;
import com.ty.bootfoodapp.dto.Item;
import com.ty.bootfoodapp.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> saveItem(List<Item> items, Foodorder foodorder) {
		List<Item> items2 = new ArrayList<Item>();
		for (Item item : items) {
			item.setFoodorder(foodorder);
			items2.add(item);
		}
		return itemRepository.saveAll(items2);

	}

	public boolean deleteFoodorderItems(Foodorder foodorder) {
		List<Item> items = foodorder.getItems();
		if (items.size() > 0) {
			itemRepository.deleteAll(items);
			return true;
		} else {
			return false;
		}

	}

}
