package com.example.demo.repository;

import com.example.demo.repository.modelo.Book;

public interface BookRepoImpl {

	public void insertar(Book book);
	public Book encontrar(Integer id);
	public void eliminar(Integer id);
	public void actualizar(Book book);
	
}
