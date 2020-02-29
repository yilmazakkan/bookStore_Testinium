package com.testinium.bookStore.dao;


import com.testinium.bookStore.entity.BookStore;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreDAO extends JpaRepository<BookStore,Long> {
    List<BookStore> findAll(Sort sort);
    BookStore getById(Long id);


}
