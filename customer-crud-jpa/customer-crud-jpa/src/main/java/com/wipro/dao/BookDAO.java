package com.wipro.dao;

import java.util.List;

import com.wipro.entity.Book;


public interface BookDAO {

	public Book getBookById(Integer isbn);
	public abstract List<Book> getAllBooks();
	public abstract String addBook(Book book);
	public abstract String updateBook(Book book);
	public abstract String deleteBook(Integer isbn);
	
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price);
	public List<Book> fetchAllBooks();
	
}
