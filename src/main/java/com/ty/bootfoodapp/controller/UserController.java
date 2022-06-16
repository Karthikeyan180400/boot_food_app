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

import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);

	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);

	}

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.getAllUser();

	}

	@PostMapping("/users/login")
	public User validateUser(@RequestBody Login login) {
		return userService.validateUser(login.getEmail(), login.getPassword());

	}

	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		return userService.updateUser(user, id);

	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		boolean res = userService.deleteUser(id);
		if (res) {
			return "Deleted";
		} else {
			return "Not Deleted";
		}
	}
}
