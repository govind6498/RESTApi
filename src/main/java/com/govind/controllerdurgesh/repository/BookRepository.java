package com.govind.controllerdurgesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.govind.controllerdurgesh.model.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	public Book findById(int id);
}
