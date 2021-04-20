package com.github.leuvaarden.library.controller;

import com.github.leuvaarden.library.dao.Book;
import com.github.leuvaarden.library.model.Books;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.UUID;

@RestController("/booker")
public class Booker {

    @Resource
    private Books books;

    @GetMapping("/{bookId}/count")
    public long countBook(@PathVariable UUID bookId) {
        Book book = books.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        return book.getCount();
    }

    @PostMapping("/{bookId}/get")
    public long getBook(@PathVariable UUID bookId) {
        Book book = books.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        if (book.getCount() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No books left");
        }
        book.setCount(book.getCount() - 1);
        books.save(book);
        return book.getCount();
    }

    @PostMapping("/{bookId}/return")
    public long returnBook(@PathVariable UUID bookId) {
        Book book = books.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        book.setCount(book.getCount() + 1);
        books.save(book);
        return book.getCount();
    }
}
