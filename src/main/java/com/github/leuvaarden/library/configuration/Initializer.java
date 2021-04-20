package com.github.leuvaarden.library.configuration;

import com.github.leuvaarden.library.dao.Author;
import com.github.leuvaarden.library.dao.Book;
import com.github.leuvaarden.library.dao.Category;
import com.github.leuvaarden.library.dao.Review;
import com.github.leuvaarden.library.model.AuthorRepository;
import com.github.leuvaarden.library.model.BookRepository;
import com.github.leuvaarden.library.model.CategoryRepository;
import com.github.leuvaarden.library.model.ReviewRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class Initializer {

    @Resource
    private AuthorRepository authorRepository;
    @Resource
    private BookRepository bookRepository;
    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private ReviewRepository reviewRepository;

    @PostConstruct
    public void init() {
        Author author1 = new Author();
        author1.setName("First A.O.");
        authorRepository.save(author1);
        Author author2 = new Author();
        author2.setName("Second S.N.");
        authorRepository.save(author2);

        Category category1 = new Category();
        category1.setName("Horror");
        categoryRepository.save(category1);
        Category category2 = new Category();
        category2.setName("Fantasy");
        categoryRepository.save(category2);

        Review review1 = new Review();
        review1.setValue("5/10");
        reviewRepository.save(review1);
        Review review2 = new Review();
        review2.setValue("6/10");
        reviewRepository.save(review2);
        Review review3 = new Review();
        review3.setValue("3/10");
        reviewRepository.save(review3);
        Review review4 = new Review();
        review4.setValue("2/10");
        reviewRepository.save(review4);

        Book book1 = new Book();
        book1.setName("Interesting story");
        book1.setAuthors(setOf(author1, author2));
        book1.setCategories(setOf(category1));
        book1.setReviews(setOf(review1));
        book1.setCount(3L);
        bookRepository.save(book1);
        Book book2 = new Book();
        book2.setName("Long novel");
        book2.setAuthors(setOf(author1));
        book2.setCategories(setOf(category1, category2));
        book2.setReviews(setOf(review2));
        book2.setCount(100L);
        bookRepository.save(book2);
        Book book3 = new Book();
        book3.setName("Love poetry");
        book3.setAuthors(setOf(author2));
        book3.setCategories(setOf(category2));
        book3.setReviews(setOf(review3, review4));
        book3.setCount(0L);
        bookRepository.save(book3);
    }

    private Set setOf(Object... elements) {
        Set set = new HashSet();
        for (Object element : elements) {
            set.add(element);
        }
        return set;
    }
}
