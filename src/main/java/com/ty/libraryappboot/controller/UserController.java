package com.ty.libraryappboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.libraryappboot.dto.User;
import com.ty.libraryappboot.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/user")
	public User saveUser(@RequestBody @Valid User user) {

		return userService.saveUser(user);
	}
	@PutMapping("/user")
	public User updateuser(@RequestParam int uid, @RequestBody User user) {
		return userService.UpdateUserById(uid, user);
	}
	@GetMapping("/user")
	public User getUserById(@RequestParam int uid) {
		return userService.getUserById(uid);
	}
	@GetMapping("/getalluser")
	public List<User> getallUser() {
		return userService.getAllUser();
	}
	@DeleteMapping("/user")
	public void deleteUser(@RequestParam int uid) {
		userService.deleteUserById(uid);
	}
	
	

	
}
