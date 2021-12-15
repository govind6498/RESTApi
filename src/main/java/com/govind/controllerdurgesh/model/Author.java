package com.govind.controllerdurgesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="authers")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int autherId;
	
	@Column(name="first_Name")
	private String firstName;
	private String lastName;
	
	private String language;
	
	@JsonBackReference
	@OneToOne(mappedBy="author")
	private Book book;
		
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getAutherId() {
		return autherId;
	}
	public void setAutherId(int autherId) {
		this.autherId = autherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
