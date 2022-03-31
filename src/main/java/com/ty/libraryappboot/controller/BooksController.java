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

import com.ty.libraryappboot.dao.ResponseStructure;
import com.ty.libraryappboot.dto.Books;
import com.ty.libraryappboot.service.BooksService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BooksController {
	@Autowired
	private BooksService booksService;
	
	@ApiOperation(value="Save Books details",produces="application/json",consumes="application/json")
	@ApiResponses({
	@ApiResponse(code=405,message="Bad Request,Not Proper Book data"),
	@ApiResponse(code=200,message="Book Saved")
	})
	@PostMapping("/books")
	public ResponseStructure<Books> saveBooks(@RequestBody Books books) {

		return booksService.saveBooks(books);
	}
	
	@ApiOperation(value = "Update Book Details By Giving Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given BookId Not Found"),
			@ApiResponse(code = 200, message = "Updated Given Book Data") })
	@PutMapping("/books")
	public ResponseStructure<Books> updateBooks(@RequestParam int uid, @RequestBody Books books) {
		return booksService.UpdateBooksById(uid, books);
	}
	
	@ApiOperation(value = "Get Book Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given BookId Not Found"),
			@ApiResponse(code = 200, message = "Getting.. Given Book Data") })
	@GetMapping("/books")
	public ResponseStructure<Books> getBooksById(@RequestParam int uid) {
		return booksService.getbooksById(uid);
	}
	
	@ApiOperation(value = "Gets All Books", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Books Not Found"),
			@ApiResponse(code = 200, message = "Getting.. All Books") })

	@GetMapping("/getallBooks")
	public ResponseStructure<List<Books>> getallBooks() {
		return booksService.getAllBooks();
	}
	
	@ApiOperation(value = "Delete Book Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({

			@ApiResponse(code = 405, message = "Given BookId Not Found"),
			@ApiResponse(code = 200, message = "Deleted Given Book Data") })
	@DeleteMapping("/books")
	public ResponseStructure<Boolean> deleteBooks(@RequestParam int uid) {
		return booksService.deleteBooksById(uid);
	}

}
