package com.testinium.bookStore.service;

import com.testinium.bookStore.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);

    List<CategoryDTO> getAll();
}
