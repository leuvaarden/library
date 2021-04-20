package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface Categories extends CrudRepository<Category, UUID> {
    @RestResource(rel = "findAll")
    List<Category> findAll();
}
