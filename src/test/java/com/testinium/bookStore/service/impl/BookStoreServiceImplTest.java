package com.testinium.bookStore.service.impl;

import com.testinium.bookStore.dao.BookAndBookStoreDAO;
import com.testinium.bookStore.dao.BookDAO;
import com.testinium.bookStore.dao.BookStoreDAO;
import com.testinium.bookStore.dao.CategoryDAO;
import com.testinium.bookStore.dto.BookDTO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.entity.Book;
import com.testinium.bookStore.entity.BookAndBookStore;
import com.testinium.bookStore.entity.BookStore;
import com.testinium.bookStore.entity.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class BookStoreServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;
    @InjectMocks
    private BookServiceImpl bookService;

    @InjectMocks
    private BookStoreServiceImpl bookStoreService;

    private  BookDAO bookDAO;
    @Mock
    private  BookStoreDAO bookStoreDAO;
    @Mock
    private  BookAndBookStoreDAO bookAndBookStoreDAO;
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
    void TestGetAllCategory() {
            Category category = new Category();
            category.setId(1L);
            category.setCategoryName("Test-Name");
            when(categoryDAO.findAll()).thenReturn(Collections.singletonList(category));
            List<CategoryDTO> categoryDTOS = categoryService.getAll();
            assertEquals(categoryDTOS.size(),1);

    }


    @Test
    public void TestBookStoreSave() {
        BookStoreDTO bookStoreDTO = new BookStoreDTO();
        BookStore bookStoreMock = mock(BookStore.class);

        bookStoreDTO.setBookStoreName("Test-Name");
        bookStoreDTO.setCity("Test-City");
        when(bookStoreMock.getId()).thenReturn(1L);
        when(bookStoreDAO.save(ArgumentMatchers.any(BookStore.class))).thenReturn(bookStoreMock);
        BookStoreDTO result = bookStoreService.save(bookStoreDTO);

        assertEquals(result.getBookStoreName(),bookStoreDTO.getBookStoreName());
        assertEquals(result.getId(),1L);


    }

    @Test
    public void TestGetAllBookStore() {
        BookStore bookStore = new BookStore();
        Book book = new Book();
        bookStore.setId(1L);
        bookStore.setBookStoreName("Test-Name");
        bookStore.setCity("Test-City");
        BookAndBookStore bookAndBookStore = new BookAndBookStore();
        bookAndBookStore.setBook(book);
        bookStore.setBookAndBookStores(Collections.singletonList(bookAndBookStore));

        when(bookStoreDAO.findAll()).thenReturn(Collections.singletonList(bookStore));
        List<BookStoreDTO> bookStoreDTOS = bookStoreService.getAll();

        assertEquals(bookStoreDTOS.size(),1);

    }
    @Test
    public void TestBookStoresEquals() {
        BookStore bookStore = new BookStore();
        Book book = new Book();
        bookStore.setId(1L);
        bookStore.setBookStoreName("Test-Name");
        bookStore.setCity("Test-City");
        BookAndBookStore bookAndBookStore = new BookAndBookStore();
        bookAndBookStore.setBook(book);
        bookStore.setBookAndBookStores(Collections.singletonList(bookAndBookStore));

        when(bookStoreDAO.findAll()).thenReturn(Collections.singletonList(bookStore));
        List<BookStoreDTO> bookStoreDTOS = bookStoreService.getAll();


        assertEquals(bookStoreDTOS.get(0), BookStoreDTO.builder().id(1L).build());

    }


}