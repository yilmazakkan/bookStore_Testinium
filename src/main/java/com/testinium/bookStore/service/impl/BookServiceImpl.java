package com.testinium.bookStore.service.impl;

import com.testinium.bookStore.dao.BookAndBookStoreDAO;
import com.testinium.bookStore.dao.BookDAO;
import com.testinium.bookStore.dao.BookStoreDAO;
import com.testinium.bookStore.dao.CategoryDAO;
import com.testinium.bookStore.dto.BookAndBookStoreDTO;
import com.testinium.bookStore.dto.BookDTO;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.dto.CategoryDTO;
import com.testinium.bookStore.entity.Book;
import com.testinium.bookStore.entity.BookAndBookStore;
import com.testinium.bookStore.entity.BookStore;
import com.testinium.bookStore.entity.Category;
import com.testinium.bookStore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final BookStoreDAO bookStoreDAO;
    private final BookAndBookStoreDAO bookAndBookStoreDAO;
    private final CategoryDAO categoryDAO;

    public BookServiceImpl(BookDAO bookDAO, BookStoreDAO bookStoreDAO, BookAndBookStoreDAO bookAndBookStoreDAO, CategoryDAO categoryDAO) {
        this.bookDAO = bookDAO;
        this.bookStoreDAO = bookStoreDAO;
        this.bookAndBookStoreDAO = bookAndBookStoreDAO;
        this.categoryDAO = categoryDAO;
    }


    @Override
    public BookDTO save(BookDTO bookDTO) {

        Book book = new Book();
        Category category = categoryDAO.getById(bookDTO.getCategory().getId());
        Book bookCodeCheck = bookDAO.getByBookCode(bookDTO.getBookCode());
        book.setBookName(bookDTO.getBookName());
        if (bookCodeCheck != null) {
            throw new IllegalArgumentException("Book Code Already exist");
        }
        book.setBookCode(bookDTO.getBookCode());
        book.setCategory(category);
        if (category == null) {
            throw new IllegalArgumentException("This category does not exist. You must enter an existing category id");
        }
        book.setPrice(bookDTO.getPrice());
        List<BookAndBookStore> bookAndBookStores = new ArrayList<>();

        Book savedBook = bookDAO.save(book);
        bookDTO.getBookAndBookStores().forEach(bookAndBookStoreDTO -> {
            BookStore bookStore = bookStoreDAO.getById(bookAndBookStoreDTO.getBookStoredId());
            if (bookStore == null) {
                return;
            }
            BookAndBookStore bookAndBookStore = new BookAndBookStore(savedBook, bookStore, bookAndBookStoreDTO.getBookPrice());
            bookAndBookStore = bookAndBookStoreDAO.save(bookAndBookStore);
            bookAndBookStores.add(bookAndBookStore);
        });
        book.getBookAndBookStores().addAll(bookAndBookStores);
        book = bookDAO.save(book);

        return convertBookToBookDTO(book);
    }


    @Override
    public BookDTO updateCategory(Long id, BookDTO bookDTO) {
        try {
            Book bookDb = bookDAO.getById(id);
            if (bookDb == null)
                throw new IllegalArgumentException("Book Does Not Exist ID: " + id);

            Category category = categoryDAO.getById(bookDTO.getCategory().getId());
            bookDb.setCategory(category);
            bookDb.setPrice(bookDTO.getPrice());
            bookDb.setBookCode(bookDTO.getBookCode());

            bookDAO.save(bookDb);
            bookDTO.setId(bookDb.getId());
            return bookDTO;
        } catch (Exception e) {
            throw new IllegalArgumentException("Book Does Not Exist ID: " + id);
        }

    }

    public List<BookDTO> getByCategory(Long categoryId) {
        List<Book> books = bookDAO.getBookByCategory_Id(categoryId);
        List<BookDTO> bookDTOS = new ArrayList<>();
        books.forEach(item -> {
            bookDTOS.add(convertBookToBookDTO(item));
        });
        return bookDTOS;

    }


    @Override
    public List<BookDTO> getAll() {
        List<Book> books = bookDAO.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        books.forEach(item -> {
            bookDTOS.add(convertBookToBookDTO(item));
        });

        return bookDTOS;
    }

    private BookDTO convertBookToBookDTO(Book item) {
        BookDTO bookDto = new BookDTO();
        bookDto.setId(item.getId());
        bookDto.setBookName(item.getBookName());
        bookDto.setBookCode(item.getBookCode());
        bookDto.setPrice(item.getPrice());
        bookDto.setCategory(new CategoryDTO(item.getCategory().getId(), item.getCategory().getCategoryName()));
        List<BookAndBookStoreDTO> bookAndBookStoreDTOS = new ArrayList<>();
        item.getBookAndBookStores().forEach(bookAndBookStore -> {
            BookStoreDTO bookStoreDTO = new BookStoreDTO(bookAndBookStore.getBookStore().getId(), bookAndBookStore.getBookStore().getBookStoreName(), bookAndBookStore.getBookStore().getCity(), null);
            BookAndBookStoreDTO bookAndBookStoreDTO = new BookAndBookStoreDTO(bookAndBookStore.getId(), null, item.getId(), bookStoreDTO, bookStoreDTO.getId(), bookAndBookStore.getBookPrice());
            bookAndBookStoreDTOS.add(bookAndBookStoreDTO);
        });
        bookDto.setBookAndBookStores(bookAndBookStoreDTOS);
        return bookDto;
    }

}
