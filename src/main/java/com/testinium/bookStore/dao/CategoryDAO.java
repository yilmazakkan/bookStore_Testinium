package com.testinium.bookStore.dao;


import com.testinium.bookStore.entity.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
    List<Category> findAll(Sort sort);
    Category getById(Long id);
}
