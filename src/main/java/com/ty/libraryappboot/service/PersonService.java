package com.ty.libraryappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.libraryappboot.dao.PersonDao;
import com.ty.libraryappboot.dto.Books;
import com.ty.libraryappboot.dto.Person;
@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;

	public Person savePerson(Person person) {
		return personDao.saveperson(person);
	}

	public Person UpdatePersonById(int id, Person person) {
		return personDao.updateperson(id, person);
	}

	public Person getPersonById(int id) {
		Person person = personDao.getPersonById(id);
		if (person == null) {
		}
		return person;
	}

	public List<Person> getAllPerson() {
		return personDao.getAllPerson();

	}

	public void deletePersonById(int id) {
		personDao.deletePersonById(id);
	}
}
