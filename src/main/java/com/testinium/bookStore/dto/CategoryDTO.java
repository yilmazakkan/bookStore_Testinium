package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Objects;

@Schema(name = "Category Data Transfer Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {


    private Long id;
    private String categoryName;
    private List<String> books;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String categoryName, List<String> books) {
        this.id = id;
        this.categoryName = categoryName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }


}
