package com.nevermind.bookapi.Services;

import com.nevermind.bookapi.Models.Book;

import java.util.List;

public interface IBookService {

    List<Book> get();
    Book getById(long id);
    Book add(Book book);
    void deleteById(long id);

}
