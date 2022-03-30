package com.ty.libraryappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.libraryappboot.dto.User;
import com.ty.libraryappboot.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository repository;

	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(int id, User user) {
		User existuser = getUserById(id);
		if (existuser!=null) {
			saveUser(user);
			return user;
		}
		return null;
	}
	
	public User getUserById(int id) {
		Optional<User> optional = repository.findById(null);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public List<User> getAllUser(){
		return repository.findAll();
	}
	public boolean deleteUserById(int id) {
		User user = getUserById(id);
		if (user!=null) {
			repository.deleteById(id);
			return true;
		}
		return false;
		
	}
}
