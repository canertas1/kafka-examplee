package com.example.microservice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
        @Id
        private String id;
        private String bookName;
        private String writer;
        private int bookStock;

}
