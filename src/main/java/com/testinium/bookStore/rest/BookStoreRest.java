package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.BookAndBookStoreDTO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.service.impl.BookStoreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookStoreRest {

    private BookStoreServiceImpl bookStoreService;

    public BookStoreRest(BookStoreServiceImpl bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @PostMapping

    public ResponseEntity<BookStoreDTO> createBookStore(@Valid @RequestBody BookStoreDTO bookStoreDTO) {
        return ResponseEntity.ok(bookStoreService.save(bookStoreDTO));
    }
    @PostMapping("/addbook")
    public ResponseEntity<BookAndBookStoreDTO> addBookToBookStore(@Valid @RequestBody BookAndBookStoreDTO bookAndBookStoreDTO) {
        return ResponseEntity.ok(bookStoreService.addBookToBookStore(bookAndBookStoreDTO));
    }

    @GetMapping
    public ResponseEntity<List<BookStoreDTO>> getAll() {
        return ResponseEntity.ok(bookStoreService.getAll());
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(bookStoreService.deleteBookFromBookStore(id));
    }
}
