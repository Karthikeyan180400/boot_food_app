package com.ty.bootfoodapp.service;

import static com.ty.bootfoodapp.util.Tax.CGST;
import static com.ty.bootfoodapp.util.Tax.SGST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.FoodorderDao;
import com.ty.bootfoodapp.dto.Foodorder;
import com.ty.bootfoodapp.dto.Item;
import com.ty.bootfoodapp.dto.Menu;

@Service
public class FoodorderService {
	@Autowired
	FoodorderDao foodorderDao;
	@Autowired
	ItemService itemService;

	public Foodorder saveOrder(Foodorder foodorder) {
		return foodorderDao.saveOrder(foodorder);

	}

	public Foodorder insertOrderCost(Foodorder foodorder) {
		double cost_sum = 0;
		List<Item> items = foodorder.getItems();
		for (Item item : items) {
			Menu menu = item.getMenu();
			String offer = menu.getOffer();
			double offer_cost = 0;
			if (offer == null) {
				offer_cost = 0;
			} else {
				offer_cost = Double.parseDouble(offer.replace("%", ""));
			}
			cost_sum = cost_sum + (item.getCost() - (item.getCost() * (offer_cost / 100)));
		}
		double total_cost = cost_sum + (cost_sum * (CGST + SGST) / 100);
		foodorder.setTotal(total_cost);
		return foodorderDao.insertOrderCost(foodorder);

	}

	public List<Foodorder> getAllFoodOrder() {
		return foodorderDao.getAllFoodOrder();

	}

	public Foodorder getFoodorderById(int id) {
		return foodorderDao.getFoodorderById(id);

	}

	public boolean deleteFoodOrder(int id) {
		return foodorderDao.deleteFoodOrder(id);
	}

}
