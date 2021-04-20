package com.github.leuvaarden.library.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "reviewId")
    @SequenceGenerator(name = "reviewId")
    private Long id;
    @Column(nullable = false)
    private String value;
}
