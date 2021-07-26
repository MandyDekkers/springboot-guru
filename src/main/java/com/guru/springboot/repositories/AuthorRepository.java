package com.guru.springboot.repositories;

import com.guru.springboot.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
