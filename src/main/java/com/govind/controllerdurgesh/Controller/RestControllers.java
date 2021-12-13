package com.govind.controllerdurgesh.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govind.controllerdurgesh.Services.BookServices;
import com.govind.controllerdurgesh.model.Book;

@RestController
public class RestControllers {

	@Autowired
	private BookServices bookService;
	
	//Get All Book
	@GetMapping("/book")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}
	
	//Get Single Book Handler
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	//add new  book
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}
	// delete book handler
	@DeleteMapping("/book/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookService.deleteBook(bookId);
	}
	
	//Update Book
	@PutMapping("book/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book,bookId);
		return book;
	}
}
