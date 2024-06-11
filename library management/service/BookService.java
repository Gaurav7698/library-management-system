package com.sctpl.admin.g1.library123.service;

import com.sctpl.admin.g1.library123.domain.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book libraryBook);

    Book fetchById(Integer bookId);

    List<Book> fetchAll();

    Book update(Book Book);

}
