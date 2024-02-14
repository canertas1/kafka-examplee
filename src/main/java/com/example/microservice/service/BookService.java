package com.example.microservice.service;

import com.example.microservice.entity.Book;
import com.example.microservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;



    public void save(Book book){
        this.bookRepository.save(book);
    }

    public Book getBook(String name){

       return bookRepository.findByBookName(name);
    }

    @KafkaListener(topics = "bookStock", groupId = "groupId")
    public void decreaseBookStock(String bookName){

        Book book = bookRepository.findByBookName(bookName);

        int stock = book.getBookStock();
        book.setBookStock(stock-1);
        bookRepository.save(book);



    }

    @KafkaListener(topics = "bookStock1", groupId = "groupId")
    public void increaseBookStock(String bookName){

        Book book = bookRepository.findByBookName(bookName);

        int stock = book.getBookStock();
        book.setBookStock(stock+1);
        bookRepository.save(book);



    }




}
