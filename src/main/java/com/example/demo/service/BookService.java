package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BookRepo;
import com.example.demo.repository.modelo.Book;
@Service
public class BookService implements BookServiceImpl{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public void agregar(Book book) {
		// TODO Auto-generated method stub
		this.bookRepo.insertar(book);
	}

	@Override
	public Book buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.bookRepo.encontrar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.bookRepo.eliminar(id);
	}

	@Override
	public void actualizar(Book book) {
		// TODO Auto-generated method stub
		this.bookRepo.actualizar(book);
	}

}
