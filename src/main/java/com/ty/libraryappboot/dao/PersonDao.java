package com.ty.libraryappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.libraryappboot.dto.Person;
import com.ty.libraryappboot.repository.PersonRepository;

@Repository
public class PersonDao {
	@Autowired
	PersonRepository repository;

	public Person saveperson(Person person) {
		return repository.save(person);
	}

	public Person updateperson(int id, Person person) {
		Person existperson = getPersonById(id);
		if (existperson != null) {
			saveperson(person);
			return person;
		}
		return null;
	}

	public Person getPersonById(int id) {
		Optional<Person> optional = repository.findById(null);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public List<Person> getAllPerson() {
		return repository.findAll();
	}

	public boolean deletePersonById(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
