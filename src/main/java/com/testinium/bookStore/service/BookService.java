package com.testinium.bookStore.service;

import com.testinium.bookStore.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO save(BookDTO bookDTO);

    BookDTO updateCategory(Long id, BookDTO bookDTO);

    List<BookDTO> getAll();

}
