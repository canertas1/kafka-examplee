package com.example.microservice.repository;

import com.example.microservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;


public interface BookRepository extends MongoRepository<Book,String> {


  Optional<Book> findById(String id );
  Optional<Book> findByBookName(String bookName);




}
