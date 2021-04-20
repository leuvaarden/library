package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @RestResource(rel = "findAllByAuthorsId")
    List<Book> findAllByAuthorsId(Long id);

    @RestResource(rel = "findAllByCategoriesId")
    List<Book> findAllByCategoriesId(Long id);
}
