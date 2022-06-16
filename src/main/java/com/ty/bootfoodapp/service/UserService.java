package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.UserDao;
import com.ty.bootfoodapp.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public User saveUser(User user) {
		return userDao.saveUser(user);

	}

	public User getUserById(int id) {
		return userDao.getUserById(id);

	}

	public List<User> getAllUser() {
		return userDao.getAllUser();

	}

	public User updateUser(User user, int id) {
		return userDao.updateUser(user, id);

	}

	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);

	}

	public User validateUser(String email, String password) {
		return userDao.validateUser(email, password);

	}

}
