package com.testinium.bookStore.dao;

import com.testinium.bookStore.entity.BookAndBookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAndBookStoreDAO extends JpaRepository<BookAndBookStore,Long> {


    @Query(value = "SELECT b from BookAndBookStore b join b.book bb where bb.id =: id")
    List<BookAndBookStore> queryByBook(@Param("id") Long id);

    @Query(value = "SELECT b from BookAndBookStore b join b.bookStore bs where bs.id =: id")
    List<BookAndBookStore> queryByBookStore(@Param("id") Long id);
}
