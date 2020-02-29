package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.util.List;

@Schema(name = "Book Data Transfer Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private Long id;
    private String bookName;
    @NotNull(message = "Book price Cannot be Empty ")
    private Double price;
    @NotNull(message = "Book Code Cannot be Empty ")
    private String bookCode;
    private CategoryDTO category;
    @NotNull(message = "category Cannot be Empty ")
    private Long categoryId;
    private List<BookAndBookStoreDTO> bookAndBookStores;

    public BookDTO() {
    }

    public BookDTO(Long id, String bookName, Double price, String bookCode, CategoryDTO category, Long categoryId, List<BookAndBookStoreDTO> bookAndBookStores) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.bookCode = bookCode;
        this.category = category;
        this.categoryId = categoryId;
        this.bookAndBookStores = bookAndBookStores;
    }


    public BookDTO(Long id, String bookName, Double price, String bookCode, List<BookAndBookStoreDTO> bookAndBookStores) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.bookCode = bookCode;
        this.bookAndBookStores = bookAndBookStores;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<BookAndBookStoreDTO> getBookAndBookStores() {
        return bookAndBookStores;
    }

    public void setBookAndBookStores(List<BookAndBookStoreDTO> bookAndBookStores) {
        this.bookAndBookStores = bookAndBookStores;
    }
}
