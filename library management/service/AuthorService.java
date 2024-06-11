package com.sctpl.admin.g1.library123.service;

import com.sctpl.admin.g1.library123.domain.Author;

import java.util.List;

public interface AuthorService {


    Author save(Author libraryAuthor);

    Author fetchById(Integer authorId);

    List<Author> fetchAll();

    Author update(Author libraryAuthor);
}
