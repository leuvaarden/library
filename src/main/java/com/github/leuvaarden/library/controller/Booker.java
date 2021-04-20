package com.github.leuvaarden.library.controller;

import com.github.leuvaarden.library.dao.Book;
import com.github.leuvaarden.library.model.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;

@RestController("/booker")
public class Booker {

    @Resource
    private BookRepository bookRepository;

    @GetMapping("/{bookId}/count")
    public long countBook(@PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        return book.getCount();
    }

    @PostMapping("/{bookId}/get")
    public long getBook(@PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        if (book.getCount() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No books left");
        }
        book.setCount(book.getCount() - 1);
        bookRepository.save(book);
        return book.getCount();
    }

    @PostMapping("/{bookId}/return")
    public long returnBook(@PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        book.setCount(book.getCount() + 1);
        bookRepository.save(book);
        return book.getCount();
    }
}
