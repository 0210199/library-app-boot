package com.ty.libraryappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.libraryappboot.dao.ResponseStructure;
import com.ty.libraryappboot.dao.UserDao;
import com.ty.libraryappboot.dto.Person;
import com.ty.libraryappboot.dto.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		userDao.saveUser(user);
		ResponseStructure<User> response = new ResponseStructure<User>();

		response.setSttaus(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(user);
		return response;
	}

	public ResponseStructure<User> UpdateUserById(int id, User user) {
		User existUser = userDao.getUserById(id);
		ResponseStructure<User> response = new ResponseStructure<User>();
		if (existUser != null) {
			userDao.updateUser(id, user);
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(user);
			return response;
		}
		return null;
	}

	public ResponseStructure<User> getUserById(int id) {
		User user = userDao.getUserById(id);
		ResponseStructure<User> response = new ResponseStructure<User>();
		if (user == null) {
		}
		response.setSttaus(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(user);
		return response;
	}

	public ResponseStructure<List<User>> getAllUser() {
		List<User> lists = userDao.getAllUser();
		ResponseStructure<List<User>> response = new ResponseStructure<List<User>>();
		if (lists != null) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(lists);
			return response;
		}
		return null;
	}

	public ResponseStructure<Boolean> deleteUserById(int id) {
		ResponseStructure<Boolean> response = new ResponseStructure<Boolean>();
		boolean status = userDao.deleteUserById(id);
		if (status) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(status);
			return response;
		}
		return null;
	}
}
