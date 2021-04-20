package com.github.leuvaarden.library.controller;

import com.github.leuvaarden.library.dao.Book;
import com.github.leuvaarden.library.model.Authors;
import com.github.leuvaarden.library.model.Books;
import com.github.leuvaarden.library.model.Categories;
import com.github.leuvaarden.library.model.Reviews;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController("/modify")
public class BookModifier {

    @Resource
    private Authors authors;
    @Resource
    private Books books;
    @Resource
    private Categories categories;
    @Resource
    private Reviews reviews;

    @PostMapping("/{bookId}/addAuthor/{authorId}")
    public Book addAuthor(@PathVariable UUID bookId, @PathVariable UUID authorId) throws Throwable {
        return add(bookId, authorId, RepoType.AUTHOR);
    }

    @PostMapping("/{bookId}/removeAuthor/{authorId}")
    public Book removeAuthor(@PathVariable UUID bookId, @PathVariable UUID authorId) throws Throwable {
        return remove(bookId, authorId, RepoType.AUTHOR);
    }

    @PostMapping("/{bookId}/addReview/{reviewId}")
    public Book addReview(@PathVariable UUID bookId, @PathVariable UUID reviewId) throws Throwable {
        return add(bookId, reviewId, RepoType.REVIEW);
    }

    @PostMapping("/{bookId}/removeReview/{reviewId}")
    public Book removeReview(@PathVariable UUID bookId, @PathVariable UUID reviewId) throws Throwable {
        return remove(bookId, reviewId, RepoType.REVIEW);
    }

    @PostMapping("/{bookId}/addCategory/{categoryId}")
    public Book addCategory(@PathVariable UUID bookId, @PathVariable UUID categoryId) throws Throwable {
        return add(bookId, categoryId, RepoType.CATEGORY);
    }

    @PostMapping("/{bookId}/removeCategory/{categoryId}")
    public Book removeCategory(@PathVariable UUID bookId, @PathVariable UUID categoryId) throws Throwable {
        return remove(bookId, categoryId, RepoType.CATEGORY);
    }


    private Book add(UUID bookId, UUID objectId, RepoType repoType) throws Throwable {
        Book book = books.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        Object object = getRepo(repoType).findById(objectId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, repoType + " not found"));
        Set set = Optional.ofNullable(getSet(book, repoType)).orElse(new HashSet<>());
        set.add(object);
        setSet(set, book, repoType);
        return books.save(book);
    }

    private Book remove(UUID bookId, UUID objectId, RepoType repoType) throws Throwable {
        Book book = books.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        Object object = getRepo(repoType).findById(objectId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, repoType + " not found"));
        Set set = Optional.ofNullable(getSet(book, repoType)).orElse(new HashSet<>());
        set.remove(object);
        setSet(set, book, repoType);
        return books.save(book);
    }

    @AllArgsConstructor
    private enum RepoType {
        REVIEW,
        AUTHOR,
        CATEGORY
    }

    private Set getSet(Book book, RepoType repoType) {
        switch (repoType) {
            case AUTHOR:
                return book.getAuthors();
            case REVIEW:
                return book.getReviews();
            default:
                return book.getCategories();
        }
    }

    private void setSet(Set set, Book book, RepoType repoType) {
        switch (repoType) {
            case AUTHOR:
                book.setAuthors(set);
                return;
            case REVIEW:
                book.setReviews(set);
                return;
            default:
                book.setCategories(set);
                return;
        }
    }

    private CrudRepository getRepo(RepoType repoType) {
        switch (repoType) {
            case AUTHOR:
                return authors;
            case REVIEW:
                return reviews;
            default:
                return categories;
        }
    }
}
