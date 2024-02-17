package com.example.microservice.dto;

import lombok.Data;

@Data
public class BookDto {


    private String bookName;
    private String writer;
    private int bookStock;

}
