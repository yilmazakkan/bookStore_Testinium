package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.BookAndBookStoreDTO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.service.impl.BookStoreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> createBookStore(@Valid @RequestBody BookStoreDTO bookStoreDTO) {

            log.info("BookStore API-> Post Create a BookStore");
            return ResponseEntity.ok(bookStoreService.save(bookStoreDTO));


    }

    @PostMapping("/addbook")
    @Operation(summary = "Add Book to BookStore")
    public ResponseEntity<?> addBookToBookStore(@Valid @RequestBody BookAndBookStoreDTO bookAndBookStoreDTO) {
        try {
            log.info("BookStore API-> Post Add Book  to BookStore");
            return ResponseEntity.ok(bookStoreService.addBookToBookStore(bookAndBookStoreDTO));
        } catch (Exception e) {
            log.error("BookStore API-> Post Add Book to BookStore Error" + e);
            return new ResponseEntity<String>("BookStore API-> Post Add Book to BookStore Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Get All BookStores")
    public ResponseEntity<?> getAll() {
        try {
            log.info("BookStore API-> Get All BookStores");
            return ResponseEntity.ok(bookStoreService.getAll());
        } catch (Exception e) {
            log.error("BookStore API-> Get All BookStores Error" + e);
            return new ResponseEntity<String>("BookStore API-> Get All BookStores Error", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/book/{id}")
    @Operation(summary = "Delete Book from BookStore")
    public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) Long id) {
        try {
            log.info("BookStore API-> Delete Book from BookStore");
            log.debug("BookStore API-> BookID -> PARAM: " + id);
            return ResponseEntity.ok(bookStoreService.deleteBookFromBookStore(id));
        } catch (Exception e) {
            log.error("BookStore API-> Delete Book from BookStore Error" + e);
            return new ResponseEntity<String>("BookStore API-> Delete Book from BookStore Error", HttpStatus.BAD_REQUEST);
        }

    }
}
