package com.testinium.bookStore.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Entity
public class BookAndBookStore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private BookStore bookStore;

    @Column(name = "book_price")
    private Double bookPrice;


    public BookAndBookStore(Book book, BookStore bookStore, Double bookPrice) {
        this.book = book;
        this.bookStore = bookStore;
        this.bookPrice = bookPrice;
    }

}
