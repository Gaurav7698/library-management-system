package com.sctpl.admin.g1.library123.service.impl;

import com.sctpl.admin.g1.library123.domain.Author;
import com.sctpl.admin.g1.library123.repository.AuthorRepository;
import com.sctpl.admin.g1.library123.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository libraryAuthorRepository;
    @Override
    public Author save(Author libraryAuthor) {
        return libraryAuthorRepository.save(libraryAuthor);
    }

    @Override
    public Author fetchById(Integer authorId) {
        return libraryAuthorRepository.fetchById(String.valueOf(authorId));
    }

    @Override
    public List<Author> fetchAll() {
        List<Author> la= libraryAuthorRepository.findAll();
           return la;
    }

//    LibraryAuthor la;
//    @Override
//    public Author update(Author author) {
//    Author libraryAuthor = libraryAuthorRepository.fetchById(String.valueOf(author.getAuthorId()));
//
//    if(Objects.nonNull(author.getAuthorId())){
//              libraryAuthor.setAuthorId(author.getAuthorId());
//    }
//        if(Objects.nonNull(author.getName()) && !"".equalsIgnoreCase(author.getName())){
//            libraryAuthor.setName(author.getName());
//        }
//        if(Objects.nonNull(author.getAge())){
//            libraryAuthor.setAge(author.getAge());
//        }
//        if(Objects.nonNull(author.getEmail()) && !"".equalsIgnoreCase(author.getEmail())){
//            libraryAuthor.setEmail(author.getEmail());
//
//        }
//        if(Objects.nonNull(author.getCountry()) && !"".equalsIgnoreCase(author.getCountry())){
//            libraryAuthor.setCountry(author.getCountry());
//
//        }
//        return libraryAuthorRepository.save(libraryAuthor);
//    }

    @Override
    public Author update(Author author) {
        Optional<Author> Author = Optional.ofNullable(libraryAuthorRepository.fetchById(String.valueOf(author.getAuthorId())));

        if (Author.isPresent()) {
            Author libraryAuthor = Author.get();

            if (author.getAuthorId() != null) {
                libraryAuthor.setAuthorId(author.getAuthorId());
            }
            if (author.getName() != null && !author.getName().isEmpty()) {
                libraryAuthor.setName(author.getName());
            }
            if (author.getAge() != null) {
                libraryAuthor.setAge(author.getAge());
            }
            if (author.getEmail() != null && !author.getEmail().isEmpty()) {
                libraryAuthor.setEmail(author.getEmail());
            }
            if (author.getCountry() != null && !author.getCountry().isEmpty()) {
                libraryAuthor.setCountry(author.getCountry());
            }

            return libraryAuthorRepository.save(libraryAuthor);
        } else {
            // Handle the case when the author with the given ID is not found
            return null;
        }
    }

}
