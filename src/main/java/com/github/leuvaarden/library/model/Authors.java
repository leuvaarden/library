package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Authors extends CrudRepository<Author, UUID> {
}
