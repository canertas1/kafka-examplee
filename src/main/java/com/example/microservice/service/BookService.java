package com.example.microservice.service;
import com.example.microservice.dto.BookDto;
import com.example.microservice.entity.Book;
import com.example.microservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;



    public void save(Book book){
        this.bookRepository.save(book);
    }

    public void updateBook(BookDto dto ){

    Optional<Book> book = bookRepository.findByBookName(dto.getBookName());

    book.get().setBookStock(dto.getBookStock());
    book.get().setBookName(dto.getBookName());
    book.get().setWriter(dto.getWriter());


    bookRepository.save(book.get());
    }

    public Book getBook(String name){

       return bookRepository.findByBookName(name).get();
    }

    @KafkaListener(topics = "bookStock", groupId = "groupId")
    public void decreaseBookStock(String bookName){

        Optional<Book> book = bookRepository.findByBookName(bookName);

        int stock = book.get().getBookStock();
        book.get().setBookStock(stock-1);
        bookRepository.save(book.get());

    }

    @KafkaListener(topics = "bookStock1", groupId = "groupId")
    public void increaseBookStock(String bookName){

        Optional<Book> book = bookRepository.findByBookName(bookName);

        int stock = book.get().getBookStock();
        book.get().setBookStock(stock+1);
        bookRepository.save(book.get());

    }




}
