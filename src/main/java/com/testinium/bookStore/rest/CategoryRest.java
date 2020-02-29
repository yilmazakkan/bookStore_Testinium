package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRest {

    private final CategoryServiceImpl categoryService;

    public CategoryRest(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @Operation(summary = "Create a Category")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }

    @GetMapping
    @Operation(summary = "Get All Categories")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

}