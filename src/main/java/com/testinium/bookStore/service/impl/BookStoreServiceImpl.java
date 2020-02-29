package com.testinium.bookStore.service.impl;

import com.testinium.bookStore.dao.BookAndBookStoreDAO;
import com.testinium.bookStore.dao.BookDAO;
import com.testinium.bookStore.dao.BookStoreDAO;
import com.testinium.bookStore.dto.BookAndBookStoreDTO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.entity.Book;
import com.testinium.bookStore.entity.BookAndBookStore;
import com.testinium.bookStore.entity.BookStore;
import com.testinium.bookStore.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreDAO bookStoreDAO;
    private final BookDAO bookDAO;
    private final BookAndBookStoreDAO bookAndBookStoreDAO;

    public BookStoreServiceImpl(BookStoreDAO bookStoreDAO, BookDAO bookDAO, BookAndBookStoreDAO bookAndBookStoreDAO) {
        this.bookStoreDAO = bookStoreDAO;
        this.bookDAO = bookDAO;

        this.bookAndBookStoreDAO = bookAndBookStoreDAO;
    }

    @Override
    public BookStoreDTO save(BookStoreDTO bookStoreDTO) {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreName(bookStoreDTO.getBookStoreName());
        bookStore.setCity(bookStoreDTO.getCity());
        bookStoreDAO.save(bookStore);
        bookStoreDTO.setId(bookStore.getId());
        return bookStoreDTO;
    }


    @Override
    public BookAndBookStoreDTO addBookToBookStore(BookAndBookStoreDTO bookAndBookStoreDTO) {


        BookAndBookStore bookAndBookStore = new BookAndBookStore();
        BookStore bookStore = bookStoreDAO.getById(bookAndBookStoreDTO.getBookStoredId());
        Book book = bookDAO.getById(bookAndBookStoreDTO.getBookId());

        bookAndBookStore.setBook(book);
        bookAndBookStore.setBookStore(bookStore);
        bookAndBookStore.setBookPrice(bookAndBookStoreDTO.getBookPrice());

        bookAndBookStoreDAO.save(bookAndBookStore);
        bookAndBookStoreDTO.setId(bookAndBookStore.getId());
        return bookAndBookStoreDTO;
    }

    @Override
    public List<BookStoreDTO> getAll() {
        List<BookStore> bookStores= bookStoreDAO.findAll();
        List<BookStoreDTO> bookStoreDTOS = new ArrayList<>();

        bookStores.forEach(item ->{
            BookStoreDTO bookStoreDTO = new BookStoreDTO();
            bookStoreDTO.setId(item.getId());
            bookStoreDTO.setBookStoreName(item.getBookStoreName());

//            List<BookAndBookStoreDTO> bookAndBookStores = new ArrayList<>();
//            item.getBookAndBookStores().forEach(bookAndBookStore -> {
//
//                BookDTO bookDTO = new BookDTO(bookAndBookStore.getBook().getId(), bookAndBookStore.getBook().getBookName(), bookAndBookStore.getBook().getPrice(), bookAndBookStore.getBook().getBookCode());
//                BookAndBookStoreDTO bookAndBookStoreDTO = new BookAndBookStoreDTO(bookAndBookStore.getId(), bookDTO, bookAndBookStore.getBook().getId(), null, bookAndBookStore.getBookStore().getId(), bookAndBookStore.getBookPrice());
//                bookAndBookStores.add(bookAndBookStoreDTO);
//            });
//            bookStoreDTO.getBookAndBookStores().addAll(bookAndBookStores);
            bookStoreDTO.setCity(item.getCity());
            bookStoreDTOS.add(bookStoreDTO);
        });
        return bookStoreDTOS;
    }


    @Override
    public Boolean deleteBookFromBookStore(Long id) {
        bookAndBookStoreDAO.deleteById(id);
        return true;
    }


}
