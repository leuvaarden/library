package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface Reviews extends CrudRepository<Review, UUID> {
    @RestResource(rel = "findAll")
    List<Review> findAll();
}
