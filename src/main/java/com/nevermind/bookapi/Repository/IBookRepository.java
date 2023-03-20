package com.nevermind.bookapi.Repository;

import com.nevermind.bookapi.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
