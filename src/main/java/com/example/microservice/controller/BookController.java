package com.example.microservice.controller;
import com.example.microservice.dto.BookDto;
import com.example.microservice.entity.Book;
import com.example.microservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;




    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Book book){

        this.bookService.save(book);

        return new ResponseEntity<>("the book has been saved", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody BookDto bookDto){

        this.bookService.updateBook(bookDto);
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Book> getBook(@PathVariable  String name){

        return new ResponseEntity<>(bookService.getBook(name),HttpStatus.OK);
    }



}
