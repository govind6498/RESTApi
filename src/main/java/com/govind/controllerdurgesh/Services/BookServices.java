package com.govind.controllerdurgesh.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.govind.controllerdurgesh.model.Book;
import com.govind.controllerdurgesh.repository.BookRepository;
@Component
public class BookServices {
	@Autowired
	private BookRepository bookRepository;
	public List<Book>getAllBooks(){
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	public Book getBookById(int id) {
		Book book =null;
		try {
			book = this.bookRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	//Adding the Book
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}
	//Delete Book
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}
	//Update The book
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
	}
}
