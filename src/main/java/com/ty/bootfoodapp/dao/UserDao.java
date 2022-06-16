package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);

	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	public User updateUser(User user, int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return userRepository.save(user);
		}

	}

	public User validateUser(String email, String password) {
		return userRepository.validateUser(email, password);

	}

	public boolean deleteUser(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			userRepository.delete(optional.get());
			return true;
		}

	}

}