package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        log.info("Category API-> Post Create a Category");
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }

    @GetMapping
    @Operation(summary = "Get All Categories")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        log.info("Category API-> Get All Categories");
        return ResponseEntity.ok(categoryService.getAll());
    }

}
