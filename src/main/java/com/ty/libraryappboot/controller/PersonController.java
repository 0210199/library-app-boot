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
import com.ty.libraryappboot.dto.Person;
import com.ty.libraryappboot.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	@ApiOperation(value="Save Person Details",produces="application/json",consumes="application/json")
	@ApiResponses({
	@ApiResponse(code=405,message="Bad Request,Not Proper Person Data"),
	@ApiResponse(code=200,message="Person Saved")
	})
	@PostMapping("/person")
	public ResponseStructure<Person> savePerson(@RequestBody @Valid Person person) {

		return personService.savePerson(person);
	}
	
	@ApiOperation(value = "Update Person Details By Giving Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given PersonId Not Found"),
			@ApiResponse(code = 200, message = "Updated Given Person Data") })
	@PutMapping("/person")
	public ResponseStructure<Person> updatePerson(@RequestParam int uid, @RequestBody Person person) {
		return personService.UpdatePersonById(uid, person);
	}
	
	@ApiOperation(value = "Get FoodOrder details by id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given PersonId Not Found"),
			@ApiResponse(code = 200, message = "Getting.. Given Person Data") })
	@GetMapping("/person")
	public ResponseStructure<Person> getPersonById(@RequestParam int uid) {
		return personService.getPersonById(uid);
	}
	
	@ApiOperation(value = "Gets All Person", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Person Not Found"),
			@ApiResponse(code = 200, message = "Getting.. All Persons") })
	@GetMapping("/getallPerson")
	public ResponseStructure<List<Person>> getallPerson() {
		return personService.getAllPerson();
	}
	
	@ApiOperation(value = "Delete Person Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given Person Not Found"),
			@ApiResponse(code = 200, message = "Deleted Given Person Data") })

	@DeleteMapping("/person")
	public ResponseStructure<Boolean> deletePerson(@RequestParam int uid) {
		return personService.deletePersonById(uid);
	}
	
	

}
