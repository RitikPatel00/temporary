package com.wipro.service;

import java.util.List;


import com.wipro.dao.BookDAO;
import com.wipro.dao.BookDaoImpl;
import com.wipro.entity.Book;


public class BookServiceImpl implements BookService {

	private BookDAO bookDao = new BookDaoImpl();
	
	
	
	@Override
	public Book getBookById(Integer isbn) {
		
		return bookDao.getBookById(isbn);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}

	@Override
	public String addBook(Book book) {
		
		return bookDao.addBook(book);
	}

	@Override
	public String updateBook(Book book) {
		
		return bookDao.updateBook(book);
	}

	@Override
	public String deleteBook(Integer isbn) {
		
		return bookDao.deleteBook(isbn);
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		
		return bookDao.getBooksByAuthor(author);
	}

	@Override
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price) {
		
		return bookDao.getBooksByAuthorGreaterThanPrice(author, price);
	}

	@Override
	public List<Book> fetchAllBooks() {
		
		return bookDao.fetchAllBooks();
	}

}
