package com.ty.libraryappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.libraryappboot.dao.PersonDao;
import com.ty.libraryappboot.dao.ResponseStructure;
import com.ty.libraryappboot.dto.Books;
import com.ty.libraryappboot.dto.Person;
import com.ty.libraryappboot.dto.User;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;

	public ResponseStructure<Person> savePerson(Person person) {
		personDao.saveperson(person);
		ResponseStructure<Person> response = new ResponseStructure<Person>();

		response.setSttaus(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(person);
		return response;
	}

	public ResponseStructure<Person> UpdatePersonById(int id, Person person) {
		Person existperson = personDao.getPersonById(id);
		ResponseStructure<Person> response = new ResponseStructure<Person>();
		if (existperson != null) {
			personDao.updateperson(id, person);
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(person);
			return response;

		}
		return null;
	}

	public ResponseStructure<Person> getPersonById(int id) {
		Person person = personDao.getPersonById(id);
		ResponseStructure<Person> response = new ResponseStructure<Person>();
		if (person == null) {
		}
		response.setSttaus(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(person);
		return response;
	}

	public ResponseStructure<List<Person>> getAllPerson() {
		List<Person> lists = personDao.getAllPerson();
		ResponseStructure<List<Person>> response = new ResponseStructure<List<Person>>();
		if (lists != null) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(lists);
			return response;
		}
		return null;

	}

	public ResponseStructure<Boolean> deletePersonById(int id) {
		ResponseStructure<Boolean> response = new ResponseStructure<Boolean>();
		boolean status = personDao.deletePersonById(id);
		if (status) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(status);
			return response;
		}
		return null;
	}
}
