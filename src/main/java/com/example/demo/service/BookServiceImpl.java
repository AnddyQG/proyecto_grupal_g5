package com.example.demo.service;

import com.example.demo.repository.modelo.Book;

public interface BookServiceImpl {
	public void agregar(Book book);
	public Book buscar(Integer id);
	public void borrar(Integer id);
	public void actualizar(Book book);
}
