package com.testinium.bookStore.dao;

import com.testinium.bookStore.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {
    List<Book> findAll(Sort sort);

    Book getById(Long id);

    Book getByBookCode(String bookCode);

    List<Book> getBookByCategory_Id(Long id);

}
