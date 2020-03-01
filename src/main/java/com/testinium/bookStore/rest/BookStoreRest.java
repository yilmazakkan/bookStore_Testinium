package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.BookAndBookStoreDTO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.service.impl.BookStoreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin
@Slf4j
public class BookStoreRest {

    private BookStoreServiceImpl bookStoreService;

    public BookStoreRest(BookStoreServiceImpl bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @PostMapping
    @Operation(summary = "Create a BookStore")
    public ResponseEntity<BookStoreDTO> createBookStore(@Valid @RequestBody BookStoreDTO bookStoreDTO) {
        log.info("BookStore API-> Post Create a BookStore");
        return ResponseEntity.ok(bookStoreService.save(bookStoreDTO));
    }
    @PostMapping("/addbook")
    @Operation(summary = "Add Book to BookStore")
    public ResponseEntity<BookAndBookStoreDTO> addBookToBookStore(@Valid @RequestBody BookAndBookStoreDTO bookAndBookStoreDTO) {

        log.info("BookStore API-> Post Add Book  to BookStore");
        return ResponseEntity.ok(bookStoreService.addBookToBookStore(bookAndBookStoreDTO));
    }

    @GetMapping
    @Operation(summary = "Get All BookStores")
    public ResponseEntity<List<BookStoreDTO>> getAll() {
        log.info("BookStore API-> Get All BookStores");
        return ResponseEntity.ok(bookStoreService.getAll());
    }

    @DeleteMapping("/book/{id}")
    @Operation(summary = "Delete Book from BookStore")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){

          log.info("BookStore API-> Delete Book from BookStore");
          log.debug("BookStore API-> BookID -> PARAM: " + id);
          return ResponseEntity.ok(bookStoreService.deleteBookFromBookStore(id));


    }
}
