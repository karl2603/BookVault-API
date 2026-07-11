package com.karl.BookVault_API.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private String title;
    private String author;
    private String category;
    private double price;
    private String status;
}
