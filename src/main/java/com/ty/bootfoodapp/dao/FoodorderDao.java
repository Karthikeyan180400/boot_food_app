package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Foodorder;
import com.ty.bootfoodapp.dto.Item;
import com.ty.bootfoodapp.repository.FoodorderRepository;
import com.ty.bootfoodapp.service.FoodorderService;
import com.ty.bootfoodapp.service.ItemService;

@Repository
public class FoodorderDao {

	@Autowired
	FoodorderRepository foodorderRepository;

	@Autowired
	ItemService itemService;

	@Lazy
	@Autowired
	FoodorderService foodorderServices;

	public Foodorder saveOrder(Foodorder foodorder) {
		Foodorder foodorder2 = foodorderRepository.save(foodorder);
		List<Item> items = foodorder2.getItems();
		List<Item> items2 = itemService.saveItem(items, foodorder2);
		foodorder2.setItems(items2);
		return foodorderServices.insertOrderCost(foodorder2);
	}

	public Foodorder insertOrderCost(Foodorder foodorder) {
		return foodorderRepository.save(foodorder);

	}

	public List<Foodorder> getAllFoodOrder() {
		return foodorderRepository.findAll();

	}

	public Foodorder getFoodorderById(int id) {
		Optional<Foodorder> optional = foodorderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	public boolean deleteFoodOrder(int id) {
		Optional<Foodorder> optional = foodorderRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			boolean res = itemService.deleteFoodorderItems(optional.get());
			if (res) {
				foodorderRepository.delete(optional.get());
				return true;
			} else {
				return false;
			}
		}

	}

}
