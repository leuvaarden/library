package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
