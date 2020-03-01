package com.testinium.bookStore.service.impl.IntegrationTest;

import com.testinium.bookStore.dao.BookAndBookStoreDAO;
import com.testinium.bookStore.dao.BookStoreDAO;
import com.testinium.bookStore.dto.BookDTO;
import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.entity.Book;
import com.testinium.bookStore.entity.BookAndBookStore;
import com.testinium.bookStore.entity.Category;
import com.testinium.bookStore.service.impl.BookServiceImpl;
import com.testinium.bookStore.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ServiceImplIntegrationTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private BookStoreDAO bookStoreDAO;
    @Autowired
    private BookAndBookStoreDAO bookAndBookStoreDAO;

    @Test
    public void TestCategorySave() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName("Test-Name");

        CategoryDTO result = categoryService.save(categoryDTO);

        assertTrue(result.getId() > 0L);


    }

}
