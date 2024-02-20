package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Book;
import com.example.demo.service.BookService;
import com.github.davidmoten.rx.jdbc.Database;

import rx.Observable;


@SpringBootApplication
public class ProyectoGrupalG5Application implements CommandLineRunner{

	
	

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoGrupalG5Application.class, args);
	}
@Autowired
	private BookService bookService;
	@Override
	public void run(String... args) throws Exception {
		Book book= new Book();
		
		book.setAutor("Anddy");
		book.setIsbn("No se");
		book.setPrice(new BigDecimal(100));
		book.setTitle("Eterno");
		
		bookService.agregar(book);
		
		
		
	}

}
