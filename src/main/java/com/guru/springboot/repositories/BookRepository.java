package com.guru.springboot.repositories;

import com.guru.springboot.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
