package com.testinium.bookStore.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookstore")
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookStore_name")
    private String bookStoreName;

    @Column(name = "bookStore_city")
    private String city;

    @OneToMany(mappedBy = "bookStore", cascade = CascadeType.ALL)
    private List<BookAndBookStore> bookAndBookStores;


    public BookStore() {
    }

    public BookStore(String bookStoreName, String city, List<BookAndBookStore> bookAndBookStores) {
        this.bookStoreName = bookStoreName;
        this.city = city;
        this.bookAndBookStores = bookAndBookStores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookStoreName() {
        return bookStoreName;
    }

    public void setBookStoreName(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<BookAndBookStore> getBookAndBookStores() {
        return bookAndBookStores;
    }

    public void setBookAndBookStores(List<BookAndBookStore> bookAndBookStores) {
        this.bookAndBookStores = bookAndBookStores;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "id=" + id +
                ", bookStoreName='" + bookStoreName + '\'' +
                ", city='" + city + '\'' +
                ", bookAndBookStores=" + bookAndBookStores +
                '}';
    }
}
