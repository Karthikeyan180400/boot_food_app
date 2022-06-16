package com.ty.bootfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bootfoodapp.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
