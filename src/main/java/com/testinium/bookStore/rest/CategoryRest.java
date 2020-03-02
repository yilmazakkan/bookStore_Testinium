package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
@Slf4j
public class CategoryRest {

    private final CategoryServiceImpl categoryService;

    public CategoryRest(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @Operation(summary = "Create a Category")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            log.info("Category API-> Post Create a Category");
            return ResponseEntity.ok(categoryService.save(categoryDTO));
        } catch (Exception e) {
            log.error("Category API-> Post Create a Category Error" + e);
            return new ResponseEntity<String>("Category API-> Post Create a Category Error", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    @Operation(summary = "Get All Categories")
    public ResponseEntity<?> getAll() {
        try {
            log.info("Category API-> Get All Categories");
            return ResponseEntity.ok(categoryService.getAll());
        } catch (Exception e) {
            log.error("Category API-> Get All Categories Error" + e);
            return new ResponseEntity<String>("Category API-> Get All Categories Error", HttpStatus.BAD_REQUEST);
        }

    }
}