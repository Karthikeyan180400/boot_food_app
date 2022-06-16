package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Foodorder;
import com.ty.bootfoodapp.service.FoodorderService;

@RestController
public class FoodorderController {

	@Autowired
	FoodorderService foodorderService;

	@PostMapping("/foodorders")
	public Foodorder saveFoodorder(@RequestBody Foodorder foodorder) {
		return foodorderService.saveOrder(foodorder);

	}

	@GetMapping("/foodorders")
	public List<Foodorder> getAllFoodorder() {
		return foodorderService.getAllFoodOrder();

	}

	@GetMapping("/foodorders/{id}")
	public Foodorder getFoodorderById(@PathVariable int id) {
		return foodorderService.getFoodorderById(id);

	}

	@DeleteMapping("/foodorders/{id}")
	public String deleteFoodorder(@PathVariable int id) {
		boolean res = foodorderService.deleteFoodOrder(id);
		if (res) {
			return "Order is Cancelled";
		} else {
			return "Order is not Cancelled";
		}

	}

}
