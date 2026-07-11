package com.karl.BookVault_API.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDTO {
    @NotBlank(message = "Title is required!")
    private String title;
    @NotBlank(message = "Author is required!")
    private String author;
    @NotBlank(message = "ISBN is required!")
    @Column(unique = true)
    private String isbn;
    @NotBlank(message = "Category is required!")
    private String category;
    @Positive(message = "Enter a valid price!")
    private double price;
    @NotBlank(message = "Published Year is required!")
    private int publishedYear;
}
