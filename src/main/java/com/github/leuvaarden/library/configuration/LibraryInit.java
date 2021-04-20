package com.github.leuvaarden.library.configuration;

import com.github.leuvaarden.library.dao.Author;
import com.github.leuvaarden.library.dao.Book;
import com.github.leuvaarden.library.dao.Category;
import com.github.leuvaarden.library.dao.Review;
import com.github.leuvaarden.library.model.Authors;
import com.github.leuvaarden.library.model.Books;
import com.github.leuvaarden.library.model.Categories;
import com.github.leuvaarden.library.model.Reviews;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;

@Configuration
public class LibraryInit {

    @Resource
    private Authors authors;
    @Resource
    private Books books;
    @Resource
    private Categories categories;
    @Resource
    private Reviews reviews;

    @PostConstruct
    public void init() {
        Author author1 = new Author();
        author1.setName("First A.O.");
        authors.save(author1);
        Author author2 = new Author();
        author2.setName("Second S.N.");
        authors.save(author2);

        Category category1 = new Category();
        category1.setName("New");
        categories.save(category1);
        Category category2 = new Category();
        category2.setName("Old");
        categories.save(category2);

        Review review1 = new Review();
        review1.setValue("5/10");
        reviews.save(review1);
        Review review2 = new Review();
        review2.setValue("6/10");
        reviews.save(review2);
        Review review3 = new Review();
        review3.setValue("3/10");
        reviews.save(review3);
        Review review4 = new Review();
        review4.setValue("2/10");
        reviews.save(review4);

        Book book1 = new Book();
        book1.setName("Interesting story");
        book1.setAuthors(Set.of(author1, author2));
        book1.setCategories(Set.of(category1));
        book1.setReviews(Set.of(review1));
        book1.setCount(3L);
        books.save(book1);
        Book book2 = new Book();
        book2.setName("Long novel");
        book2.setAuthors(Set.of(author1));
        book2.setCategories(Set.of(category1, category2));
        book2.setReviews(Set.of(review2));
        book2.setCount(100L);
        books.save(book2);
        Book book3 = new Book();
        book3.setName("Love poetry");
        book3.setAuthors(Set.of(author2));
        book3.setCategories(Set.of(category2));
        book3.setReviews(Set.of(review3, review4));
        book3.setCount(0L);
        books.save(book3);
    }
}
