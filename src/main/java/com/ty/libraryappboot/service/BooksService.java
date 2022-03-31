package com.ty.libraryappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.libraryappboot.dao.BooksDao;
import com.ty.libraryappboot.dao.ResponseStructure;
import com.ty.libraryappboot.dto.Books;
import com.ty.libraryappboot.dto.Person;

@Service
public class BooksService {
	@Autowired
	private BooksDao booksDao;

	public ResponseStructure<Books> saveBooks(Books books) {
		booksDao.savebooks(books);
		ResponseStructure<Books> response = new ResponseStructure<Books>();

		response.setSttaus(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(books);
		return response;
	}

	public ResponseStructure<Books> UpdateBooksById(int id, Books books) {
		Books book = booksDao.getBooksById(id);
		if (book != null) {
			booksDao.updateBooks(id, books);
			ResponseStructure<Books> response = new ResponseStructure<Books>();
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(books);
			return response;
		}
		return null;

	}

	public ResponseStructure<Books> getbooksById(int id) {
		Books books = booksDao.getBooksById(id);
		ResponseStructure<Books> response = new ResponseStructure<Books>();
		if (books == null) {
		}
		response.setSttaus(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(books);
		return response;
	}

	public ResponseStructure<List<Books>> getAllBooks() {
		List<Books> lists = booksDao.getAllBooks();
		ResponseStructure<List<Books>> response = new ResponseStructure<List<Books>>();
		if (lists != null) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(lists);
			return response;
		}
		return null;

	}

	public ResponseStructure<Boolean> deleteBooksById(int id) {
		ResponseStructure<Boolean> response = new ResponseStructure<Boolean>();
		boolean status = booksDao.deleteBooksById(id);
		if (status) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(status);
			return response;
		}
		return null;
	}

	public ResponseStructure<List<Books>> getBooksByPersonId(int id) {
		List<Books> lists = booksDao.getBooksByPersonId(id);
		ResponseStructure<List<Books>> response = new ResponseStructure<List<Books>>();
		if (lists != null) {
			response.setSttaus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(lists);
			return response;
		}
		return null;
	}
}
