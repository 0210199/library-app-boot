package com.ty.libraryappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.libraryappboot.dao.UserDao;
import com.ty.libraryappboot.dto.User;
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	public User UpdateUserById(int id,User user) {
		return userDao.updateUser(id,user);
	}
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		if (user == null) {
		}
		return user;
	}
	public List<User> getAllUser(){
		return userDao.getAllUser();
				
	}
	public void deleteUserById(int id) {
		 userDao.deleteUserById(id);
	}
}
