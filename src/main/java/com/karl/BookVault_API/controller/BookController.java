package com.karl.BookVault_API.controller;

import com.karl.BookVault_API.dto.request.BookRequestDTO;
import com.karl.BookVault_API.dto.response.BookResponseDTO;
import com.karl.BookVault_API.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("bookvault")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/api/v1/books")
    public List<BookResponseDTO> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/api/v1/books/{id}")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable("id") int id){
        BookResponseDTO response = service.getBook(id);
        if(response == null){
            throw new NoSuchElementException();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/api/v1/books")
    public ResponseEntity<String> addBook(@Valid @RequestBody BookRequestDTO requestDTO){
        service.addBook(requestDTO);
        return new ResponseEntity<>("Book Added", HttpStatus.CREATED);
    }

}
