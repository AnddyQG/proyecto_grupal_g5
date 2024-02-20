package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@SequenceGenerator(name = "seq_book", sequenceName = "seq_book", allocationSize = 1)
	@GeneratedValue(generator = "seq_book", strategy = GenerationType.SEQUENCE)
	@Column(name = "book_id")
	private Integer id;
	
	@Column(name = "book_autor")
	private String autor;
	@Column(name = "book_isbn")
	private String isbn;
	@Column(name = "book_title")
	private String title;
	@Column(name = "book_price")
	private BigDecimal price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", autor=" + autor + ", isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}
	
	
	
	
}
