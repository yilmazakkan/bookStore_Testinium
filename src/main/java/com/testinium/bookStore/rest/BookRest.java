package com.testinium.bookStore.rest;

import com.testinium.bookStore.dto.BookDTO;
import com.testinium.bookStore.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
@Slf4j
public class BookRest {

    private BookServiceImpl bookService;

    public BookRest(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @Operation(summary = "Create a Book")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookDTO bookDTO) {
        try {
            log.info("Book API-> Post");

            BookDTO response = bookService.save(bookDTO);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Book API -> Add book Error" + e);
            return new ResponseEntity<String>("Book API -> Add Book Error", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/category/{id}")
    @Operation(summary = "List books by category")
    public ResponseEntity<?> getByCategory(@PathVariable(value = "id") Long id) {
        try {
            log.info("Book API->  List By Category ID the of the Book");
            List<BookDTO> response = bookService.getByCategory(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("List By Category ID Error" + e);
            return new ResponseEntity<String>("List By Category ID Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Get All Books")
    public ResponseEntity<?> getAll() {
        try {
            log.info("Book API -> Get All Books");
            return ResponseEntity.ok(bookService.getAll());
        } catch (Exception e) {
            log.error("Get All Books Error" + e);
            return new ResponseEntity<String>("Get All Books Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the Category of the Book")
    public ResponseEntity<?> updateBookCategory(@PathVariable(value = "id", required = true) Long id, @RequestBody BookDTO bookDTO) {
        try {
            log.info("Book API-> Update Category Get By Book Id");

            log.debug("Book API-> Update GetByID -> PARAM: " + id);

            BookDTO response = bookService.updateCategory(id, bookDTO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Update book Error" + e);
            return new ResponseEntity<String>("List By Category ID Error", HttpStatus.BAD_REQUEST);
        }
    }
}
