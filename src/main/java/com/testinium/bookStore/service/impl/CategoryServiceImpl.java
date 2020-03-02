package com.testinium.bookStore.service.impl;

import com.testinium.bookStore.dao.CategoryDAO;
import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.entity.Category;
import com.testinium.bookStore.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Transactional
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = new Category();
        Category categoryCheck = categoryDAO.getByCategoryName(categoryDTO.getCategoryName());
        if (categoryCheck != null){
            throw new IllegalArgumentException("This Category Already exist");
        }
        category.setCategoryName(categoryDTO.getCategoryName());
        Category categoryDb = categoryDAO.save(category);
        categoryDTO.setId(categoryDb.getId());
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> getAll() {

        List<Category> categories = categoryDAO.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        categories.forEach(item -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(item.getId());
            categoryDTO.setCategoryName(item.getCategoryName());

            categoryDTOS.add(categoryDTO);
        });
        return categoryDTOS;
    }

}
