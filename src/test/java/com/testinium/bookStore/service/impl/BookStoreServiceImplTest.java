package com.testinium.bookStore.service.impl;

import com.testinium.bookStore.dao.CategoryDAO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.entity.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class BookStoreServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private  CategoryDAO categoryDAO;

    @Test
   public void TestCategorySave() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName("Test-Name");
        Category categoryMock = mock(Category.class);

        when(categoryMock.getId()).thenReturn(1L);
        when(categoryDAO.save(ArgumentMatchers.any(Category.class))).thenReturn(categoryMock);
        CategoryDTO result = categoryService.save(categoryDTO);


        assertEquals(result.getCategoryName(),categoryDTO.getCategoryName());
        assertEquals(result.getId(),1L);
    }

    @Test
    void getAll() {
    }

    @Test
    public void TestBookStoreSave() {
        BookStoreDTO bookStoreDTO = new BookStoreDTO();
        bookStoreDTO.setBookStoreName("Test-Name");
        bookStoreDTO.setCity("Test-City");

    }

}