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
		
		Database db = Database.from("jdbc:postgresql://localhost:5432/libros", "postgres", "admin");
		
		Observable<Book> book = db.select("SELECT book_id, book_autor, book_isbn, book_title, book_price FROM book")
		.get(rs -> new Book(
			rs.getInt("book_id"),
			rs.getString("book_autor"),
			rs.getString("book_isbn"),
			rs.getString("book_title"),
			rs.getBigDecimal("book_price")
		));

// Imprimir todos los libros
book.subscribe(System.out::println);
		
		


/* 
		Book newBook = new Book(2, "autor", "isbn", "titulo", new BigDecimal("9.99"));

db.update("INSERT INTO Book (book_id,book_autor, book_isbn, book_title, book_price) VALUES (3,'Jimmy', 'Ortega', 'adasd', 9.99)")
  .parameters(newBook.getAutor(), newBook.getIsbn(), newBook.getTitle(), newBook.getPrice())
  .returnGeneratedKeys()
  .getAs(Integer.class)
  .subscribe(id -> {
      newBook.setId(id);
      System.out.println("Nuevo libro creado con ID: " + id);
  });
*/
/* 
Book bookToUpdate = new Book(3, "nuevo autor", "nuevo isbn", "nuevo titulo", new BigDecimal("19.99"));

db.update("UPDATE Book SET book_autor = 'Jimmy', book_isbn = 'Ortega', book_title = 'Ya valio', book_price = 19.80 WHERE book_id = 3")
  .parameters(bookToUpdate.getAutor(), bookToUpdate.getIsbn(), bookToUpdate.getTitle(), bookToUpdate.getPrice(), bookToUpdate.getId())
  .count()
  .subscribe(updatedRows -> System.out.println("Filas actualizadas: " + updatedRows));

*/


int idToDelete = 1;

db.update("DELETE FROM Book WHERE book_id = 3")
  .parameter(idToDelete)
  .count()
  .subscribe(deletedRows -> System.out.println("Filas eliminadas: " + deletedRows));



	}



}
