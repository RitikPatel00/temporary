package com.wipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wipro.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class BookDaoImpl implements BookDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-crud-jpa");

	@Override
	public Book getBookById(Integer isbn) {


		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Book book = em.find(Book.class, isbn);
			return book;

		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Book> getAllBooks() {
		EntityManager em = null;
		String jql = " select c from Book c";
		try {
			em = emf.createEntityManager();
			TypedQuery<Book> query = em.createQuery(jql,Book.class);
			List<Book> bookList = query.getResultList();
			return bookList;
		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addBook(Book book) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(book);
			em.getTransaction().commit();
			return "Book added";


		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return "Unable to add Book";
	}

	@Override
	public String updateBook(Book book) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(book);
			em.getTransaction().commit();
			return "Book updated";


		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return "Unable to update book";
	}

	@Override
	public String deleteBook(Integer isbn) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Book book = em.find(Book.class, isbn);
			em.remove(book);
			em.getTransaction().commit();
			return "Book deleted";


		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return "Unable to delete book";
	}

	
	// :pauthor is called Named parameter
	@Override
	public List<Book> getBooksByAuthor(String author) {
		String jql = "select b from Book b where b.author = :pauthor"; 

		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			TypedQuery<Book> query = em.createQuery(jql,Book.class);
			query.setParameter("pauthor", author);
			List<Book> bookList = query.getResultList();
			return bookList;

		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price) {
		// ?1 and ?2 are called Ordinal parameters. 
		String jql = "select b from Book b where b.author = ?1 and b.price > ?2"; 

		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			TypedQuery<Book> query = em.createQuery(jql,Book.class);
			query.setParameter(1, author);
			query.setParameter(2, price);
			
			List<Book> bookList = query.getResultList();
			return bookList;

		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> fetchAllBooks() {
		EntityManager em = null;
		String jql = " select c from Book c";
		try {
			em = emf.createEntityManager();
			Query query = em.createNamedQuery("fetchAllBooks");
			List<Book> bookList = query.getResultList();
			return bookList;
		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;
	}

}
