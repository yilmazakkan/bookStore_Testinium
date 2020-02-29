package com.testinium.bookStore.service;

import com.testinium.bookStore.dto.BookAndBookStoreDTO;
import com.testinium.bookStore.dto.BookStoreDTO;

import java.util.List;

public interface BookStoreService {
    BookStoreDTO save(BookStoreDTO bookStoreDTO);
    List<BookStoreDTO> getAll();
    Boolean deleteBookFromBookStore(Long id);
    BookAndBookStoreDTO addBookToBookStore(BookAndBookStoreDTO bookAndBookStoreDTO);
}
