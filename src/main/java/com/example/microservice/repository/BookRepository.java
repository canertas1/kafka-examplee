package com.example.microservice.repository;

import com.example.microservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BookRepository extends MongoRepository<Book,Integer> {


  Book findById(int id);

  Book findByBookName(String name);

}
