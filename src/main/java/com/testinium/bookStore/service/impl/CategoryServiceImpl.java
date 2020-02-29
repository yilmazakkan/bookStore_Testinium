package com.testinium.bookStore.service.impl;

import com.testinium.bookStore.dao.CategoryDAO;
import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.entity.Book;
import com.testinium.bookStore.entity.Category;
import com.testinium.bookStore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryDAO.save(category);
        categoryDTO.setId(category.getId());
        return  categoryDTO;
    }

    @Override
    public List<CategoryDTO> getAll() {

        List<Category> categories= categoryDAO.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        categories.forEach(item ->{
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(item.getId());
            categoryDTO.setCategoryName(item.getCategoryName());

            categoryDTO.setBooks(
                    item.getBooks() != null ?
                    item.getBooks().stream().map(Book::getBookName).collect(Collectors.toList())
                            : null
            );
            categoryDTOS.add(categoryDTO);
        });
        return categoryDTOS;
    }

}
