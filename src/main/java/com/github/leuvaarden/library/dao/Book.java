package com.github.leuvaarden.library.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "bookId")
    @SequenceGenerator(name = "bookId")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long count;
    @ManyToMany
    private Set<Author> authors;
    @ManyToMany
    private Set<Category> categories;
    @OneToMany
    private Set<Review> reviews;
}
