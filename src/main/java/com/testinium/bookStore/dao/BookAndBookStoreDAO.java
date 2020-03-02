package com.testinium.bookStore.dao;

import com.testinium.bookStore.entity.BookAndBookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookAndBookStoreDAO extends JpaRepository<BookAndBookStore, Long> {


}
