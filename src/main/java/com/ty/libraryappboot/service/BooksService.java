package com.ty.libraryappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.libraryappboot.dao.BooksDao;
import com.ty.libraryappboot.dto.Books;

@Service
public class BooksService {
	@Autowired
	private BooksDao booksDao;
	
	
	public Books saveBooks(Books books) {
		return booksDao.savebooks(books);
	}
	public Books UpdateBooksById(int id,Books books) {
		return booksDao.updateBooks(id,books);
	}
	public Books getbooksById(int id) {
		Books books = booksDao.getBooksById(id);
		if (books == null) {
		}
		return books;
	}
	public List<Books> getAllBooks(){
		return booksDao.getAllBooks();
				
	}
	public void deleteBooksById(int id) {
		 booksDao.deleteBooksById(id);
	}
	public List<Books> getBooksByPersonId(int id) {
		return booksDao.getBooksByPersonId(id);
	}
}
