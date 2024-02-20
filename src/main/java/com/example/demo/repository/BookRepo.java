package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional

public class BookRepo implements BookRepoImpl{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Book book) {
		// TODO Auto-generated method stub
		this.entityManager.persist(book);
	}

	@Override
	public Book encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Book.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(id);
		
	}

	@Override
	public void actualizar(Book book) {
		// TODO Auto-generated method stub
		this.entityManager.merge(book);
	}

}
