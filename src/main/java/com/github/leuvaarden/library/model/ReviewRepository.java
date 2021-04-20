package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
}
