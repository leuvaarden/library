package com.github.leuvaarden.library.model;

import com.github.leuvaarden.library.dao.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
