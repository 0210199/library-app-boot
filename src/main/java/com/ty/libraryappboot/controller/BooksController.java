package com.ty.libraryappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.libraryappboot.dto.Books;
import com.ty.libraryappboot.service.BooksService;

@RestController
public class BooksController {
	@Autowired
	private BooksService booksService;

	@PostMapping("/books")
	public Books saveBooks(@RequestBody Books books) {

		return booksService.saveBooks(books);
	}

	@PutMapping("/books")
	public Books updateBooks(@RequestParam int uid, @RequestBody Books books) {
		return booksService.UpdateBooksById(uid, books);
	}

	@GetMapping("/books")
	public Books getBooksById(@RequestParam int uid) {
		return booksService.getbooksById(uid);
	}

	@GetMapping("/getallBooks")
	public List<Books> getallBooks() {
		return booksService.getAllBooks();
	}

	@DeleteMapping("/books")
	public void deleteBooks(@RequestParam int uid) {
		booksService.deleteBooksById(uid);
	}

}
