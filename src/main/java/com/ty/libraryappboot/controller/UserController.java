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

import com.ty.libraryappboot.dao.ResponseStructure;
import com.ty.libraryappboot.dto.User;
import com.ty.libraryappboot.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@ApiOperation(value="Save User Details",produces="application/json",consumes="application/json")
	@ApiResponses({
	@ApiResponse(code=405,message="Bad Request,Not Proper User Data"),
	@ApiResponse(code=200,message="User Saved")
	})
	@PostMapping("/user")
	public ResponseStructure<User> saveUser(@RequestBody @Valid User user) {

		return userService.saveUser(user);
	}
	
	@ApiOperation(value = "Update User Details By Giving Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given UserId Not Found"),
			@ApiResponse(code = 200, message = "Updated Given User Data") })
	@PutMapping("/user")
	public ResponseStructure<User> updateuser(@RequestParam int uid, @RequestBody User user) {
		return userService.UpdateUserById(uid, user);
	}
	
	@ApiOperation(value = "Get User Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given UsererId Not Found"),
			@ApiResponse(code = 200, message = "Getting.. Given User Data") })
	@GetMapping("/user")
	public ResponseStructure<User> getUserById(@RequestParam int uid) {
		return userService.getUserById(uid);
	}
	
	@ApiOperation(value = "Gets All Users", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "User Not Found"),
			@ApiResponse(code = 200, message = "Getting.. All Users") })
	@GetMapping("/getalluser")
	public ResponseStructure<List<User>> getallUser() {
		return userService.getAllUser();
	}
	
	@ApiOperation(value = "Delete User Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given User Not Found"),
			@ApiResponse(code = 200, message = "Deleted Given User Data") })

	@DeleteMapping("/user")
	public ResponseStructure<Boolean> deleteUser(@RequestParam int uid) {
		return userService.deleteUserById(uid);
	}
	
	

	
}
