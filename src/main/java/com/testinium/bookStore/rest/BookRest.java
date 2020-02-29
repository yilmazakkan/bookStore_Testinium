package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.BookDTO;
import com.testinium.bookStore.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRest {

    private BookServiceImpl bookService;

    public BookRest(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @Operation(summary = "Create a Book")
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO response = bookService.save(bookDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Get All Books")
    public ResponseEntity<List<BookDTO>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the Category of the Book")
    public ResponseEntity<BookDTO> updateBookCategory(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody BookDTO bookDTO) {
        BookDTO response = bookService.updateCategory(id, bookDTO);
        return ResponseEntity.ok(response);
    }
}
