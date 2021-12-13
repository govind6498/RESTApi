package com.govind.controllerdurgesh.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.govind.controllerdurgesh.model.Book;
@Component
public class BookServices {
	private static List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(123,"Java complete Refrence","XYZ"));
		list.add(new Book(456,"Thanks Java","abc"));
		list.add(new Book(789,"Hii Govind Kumar. You complete Java session","pqr"));
	}
	public List<Book>getAllBooks(){
		return list;
	}
	public Book getBookById(int id) {
		Book book =null;
		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	//Adding the Book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	//Delete Book
	public void deleteBook(int bookId) {
		list = list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
		
	}
	//Update The book
	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
