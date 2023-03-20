package com.nevermind.bookapi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 512)
    private String title;
    @NotBlank
    @Size(max = 128)
    private String author;
    @NotBlank
    @Size(max = 128)
    private String language;
    @NotNull
    private LocalDateTime releaseDate;
    @NotBlank
    @Size(max = 13)
    private String isbn;

}
