package com.guru.springboot.bootstrap;

import com.guru.springboot.domain.Author;
import com.guru.springboot.domain.Book;
import com.guru.springboot.domain.Publisher;
import com.guru.springboot.repositories.AuthorRepository;
import com.guru.springboot.repositories.BookRepository;
import com.guru.springboot.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author2 = new Author("Erik", "Evans");
        Book book2 = new Book("Domain Driven Design", "123123");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        Publisher publisher1 = new Publisher("Mandy", "addressLine 1", "city", "state", "zip");
        publisherRepository.save(publisher1);

        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        Author author1 = new Author("Rod", "Johnson");
        Book book1 = new Book("Development", "123123123213");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        System.out.println(publisherRepository.count());
        System.out.println(bookRepository.count());
        System.out.println(publisher1.getBooks().size());

    }
}
