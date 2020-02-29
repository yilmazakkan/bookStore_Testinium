package com.testinium.bookStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private Double price;

    @Column(name = "book_code")
    private String bookCode;

    @ManyToOne
    @JoinColumn
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookAndBookStore> bookAndBookStores = new ArrayList<>();


    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<BookAndBookStore> getBookAndBookStores() {
        return bookAndBookStores;
    }

    public void setBookAndBookStores(List<BookAndBookStore> bookAndBookStores) {
        this.bookAndBookStores = bookAndBookStores;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(price, book.price) &&
                Objects.equals(bookCode, book.bookCode) &&
                Objects.equals(category, book.category) &&
                Objects.equals(bookAndBookStores, book.bookAndBookStores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, price, bookCode, category, bookAndBookStores);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", bookCode='" + bookCode + '\'' +
                ", category=" + category +
                ", bookAndBookStores=" + bookAndBookStores +
                '}';
    }
}
