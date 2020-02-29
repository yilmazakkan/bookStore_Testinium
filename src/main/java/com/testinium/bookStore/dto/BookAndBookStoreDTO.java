package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookAndBookStoreDTO {

    private Long id;
    private BookDTO book;
    private Long bookId;

    private BookStoreDTO bookStore;
    private Long bookStoredId;

    private Double bookPrice;

    public BookAndBookStoreDTO() {
    }

    public BookAndBookStoreDTO(Long id, BookDTO book, Long bookId, BookStoreDTO bookStore, Long bookStoredId, Double bookPrice) {
        this.id = id;
        this.book = book;
        this.bookId = bookId;
        this.bookStore = bookStore;
        this.bookStoredId = bookStoredId;
        this.bookPrice = bookPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public BookStoreDTO getBookStore() {
        return bookStore;
    }

    public void setBookStore(BookStoreDTO bookStore) {
        this.bookStore = bookStore;
    }

    public Long getBookStoredId() {
        return bookStoredId;
    }

    public void setBookStoredId(Long bookStoredId) {
        this.bookStoredId = bookStoredId;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
