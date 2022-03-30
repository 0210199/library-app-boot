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

import com.ty.libraryappboot.dto.Person;
import com.ty.libraryappboot.service.PersonService;
@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	@PostMapping("/person")
	public Person savePerson(@RequestBody @Valid Person person) {

		return personService.savePerson(person);
	}
	@PutMapping("/person")
	public Person updatePerson(@RequestParam int uid, @RequestBody Person person) {
		return personService.UpdatePersonById(uid, person);
	}
	@GetMapping("/person")
	public Person getPersonById(@RequestParam int uid) {
		return personService.getPersonById(uid);
	}
	@GetMapping("/getallPerson")
	public List<Person> getallPerson() {
		return personService.getAllPerson();
	}
	@DeleteMapping("/person")
	public void deletePerson(@RequestParam int uid) {
		personService.deletePersonById(uid);
	}
	
	

}
