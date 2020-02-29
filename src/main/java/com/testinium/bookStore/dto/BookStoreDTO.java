package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(name = "BookStore Data Transfer Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookStoreDTO {

    private Long id;
    private String bookStoreName;
    private String city;
    private List<BookAndBookStoreDTO> bookAndBookStores;
    private List<String> bookAndStore;

    public BookStoreDTO() {
    }

    public BookStoreDTO(Long id, String bookStoreName, String city, List<BookAndBookStoreDTO> bookAndBookStores, List<String> bookAndStore) {
        this.id = id;
        this.bookStoreName = bookStoreName;
        this.city = city;
        this.bookAndBookStores = bookAndBookStores;
        this.bookAndStore = bookAndStore;
    }

    public List<String> getBookAndStore() {
        return bookAndStore;
    }

    public void setBookAndStore(List<String> bookAndStore) {
        this.bookAndStore = bookAndStore;
    }

    public BookStoreDTO(Long id, String bookStoreName, String city, List<BookAndBookStoreDTO> bookAndBookStores) {
        this.id = id;
        this.bookStoreName = bookStoreName;
        this.city = city;
        this.bookAndBookStores = bookAndBookStores;
    }

    public BookStoreDTO(Long id, String bookStoreName, String city) {
        this.id = id;
        this.bookStoreName = bookStoreName;
        this.city = city;
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

    public List<BookAndBookStoreDTO> getBookAndBookStores() {
        return bookAndBookStores;
    }

    public void setBookAndBookStores(List<BookAndBookStoreDTO> bookAndBookStores) {
        this.bookAndBookStores = bookAndBookStores;
    }
}
