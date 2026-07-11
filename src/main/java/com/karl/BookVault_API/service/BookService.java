package com.karl.BookVault_API.service;

import com.karl.BookVault_API.dto.request.BookRequestDTO;
import com.karl.BookVault_API.dto.response.BookResponseDTO;
import com.karl.BookVault_API.model.Book;
import com.karl.BookVault_API.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<BookResponseDTO> getAllBooks(){
        List<Book> books = repository.findAll();
        List<BookResponseDTO> response = new ArrayList<>();
        for(int i=0; i<books.size(); i++){
            Book book = books.get(i);
            BookResponseDTO responseBook = new BookResponseDTO(book.getTitle(), book.getAuthor(), book.getCategory(), book.getPrice(), book.getStatus());
            response.add(responseBook);
        }
        return response;
    }

    public void addBook(BookRequestDTO requestDTO){
        Book book = new Book();
        book.setTitle(requestDTO.getTitle());
        book.setAuthor(requestDTO.getAuthor());
        book.setIsbn(requestDTO.getIsbn());
        book.setCategory(requestDTO.getCategory());
        book.setPrice(requestDTO.getPrice());
        book.setPublishedYear(requestDTO.getPublishedYear());
        book.setStatus("Available");
        book.setCreatedAt(LocalDateTime.now());
        repository.save(book);
    }
}
