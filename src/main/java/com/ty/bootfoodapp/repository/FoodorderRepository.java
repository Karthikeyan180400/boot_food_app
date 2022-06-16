package com.ty.bootfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bootfoodapp.dto.Foodorder;

public interface FoodorderRepository extends JpaRepository<Foodorder, Integer> {

}
