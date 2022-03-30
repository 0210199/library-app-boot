package com.ty.libraryappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.libraryappboot.dto.Books;
import com.ty.libraryappboot.dto.Person;
import com.ty.libraryappboot.repository.BooksRepository;

@Repository
public class BooksDao {
	@Autowired
	BooksRepository repository;
	@Autowired
	PersonDao dao;

	
	public Books savebooks(Books books) {
		return repository.save(books);
	}
	
	public Books updateBooks(int id, Books books) {
		Books existbooks = getBooksById(id);
		if (existbooks!=null) {
			savebooks(books);
			return books;
		}
		return null;
	}
	
	public Books getBooksById(int id) {
		Optional<Books> optional = repository.findById(null);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public List<Books> getAllBooks(){
		return repository.findAll();
	}
	public boolean deleteBooksById(int id) {
		Books books = getBooksById(id);
		if (books!=null) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	public List<Books> getBooksByPersonId(int id) {
		Person person = dao.getPersonById(id);
		return person.getBorrowed_books();
	}
}
