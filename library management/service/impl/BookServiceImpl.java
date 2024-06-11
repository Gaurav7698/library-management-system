package com.sctpl.admin.g1.library123.service.impl;


import com.sctpl.admin.g1.library123.domain.Book;
import com.sctpl.admin.g1.library123.repository.BookRepository;
import com.sctpl.admin.g1.library123.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sctpl.admin.g1.library123.repository.AuthorRepository;
import java.util.List;
import java.util.Objects;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Book saveBook(Book libraryBook) {
        return bookRepository.save(libraryBook);
    }

    @Override
    public Book fetchById(Integer bookId) {
        return bookRepository.fetchById(bookId);
    }

    @Override
    public List<Book> fetchAll() {
        return bookRepository.findAll();
    }


        @Override
                public Book update(Book book) {
            Book existingBook = bookRepository.fetchById(book.getBookId());

            if (existingBook != null) {
                // Update book properties
                if (Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())) {
                    existingBook.setBookName(book.getBookName());
                }
                if (Objects.nonNull(book.getNumberOfPage())) {
                    existingBook.setNumberOfPage(book.getNumberOfPage());
                }
                if (Objects.nonNull(book.getAvailable())) {
                    existingBook.setAvailable(book.getAvailable());
                }

//                // Update author properties
//                Optional<Author> optionalAuthor = Optional.ofNullable(authorRepository.fetchById(String.valueOf(author.getAuthorId())));
//
//                if (optionalAuthor.isPresent()) {
//                    Author libraryAuthor = optionalAuthor.get();
//                    if (Objects.nonNull(author.getName()) && !author.getName().isEmpty()) {
//                        libraryAuthor.setName(author.getName());
//                    }
//                    if (Objects.nonNull(author.getAge())) {
//                        libraryAuthor.setAge(author.getAge());
//                    }
//                    if (Objects.nonNull(author.getEmail()) && !author.getEmail().isEmpty()) {
//                        libraryAuthor.setEmail(author.getEmail());
//                    }
//                    if (Objects.nonNull(author.getCountry()) && !author.getCountry().isEmpty()) {
//                        libraryAuthor.setCountry(author.getCountry());
//                    }
//
//                    // Set the updated author to the book
//                    authorRepository.save(libraryAuthor);
//                }
            }


            return bookRepository.save(existingBook);
        }



//    @Override
//    public Book update(Book book) {
//        Book bookId = bookRepository.fetchById(book.getBookId());
//     if(bookId != null){
//        if (Objects.nonNull(book.getBookId())) {
//            bookId.setBookId(book.getBookId());
//        }
//        if (Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())) {
//            bookId.setBookName(book.getBookName());
//        }
//        if (Objects.nonNull(book.getNumberOfPage())) {
//            bookId.setNumberOfPage(book.getNumberOfPage());
//        }
//        if (Objects.nonNull(book.getAvailable())) {
//            bookId.setAvailable(book.getAvailable());
//        }
//
//
//
//         if (Objects.nonNull(book.getAuthor())) {
//             Author existingAuthor = book.getAuthor();
//
//             // Update author details if provided
//             if (Objects.nonNull(book.getAuthor().getName()) && !"".equalsIgnoreCase(book.getAuthor().getName())) {
//                 existingAuthor.setName(book.getAuthor().getName());
//             }
//             if (Objects.nonNull(book.getAuthor().getEmail()) && !"".equalsIgnoreCase(book.getAuthor().getEmail())) {
//                 existingAuthor.setEmail(book.getAuthor().getEmail());
//             }
//             if (Objects.nonNull(book.getAuthor().getAge())) {
//                 existingAuthor.setAge(book.getAuthor().getAge());
//             }
//             if (Objects.nonNull(book.getAuthor().getCountry()) && !"".equalsIgnoreCase(book.getAuthor().getCountry())) {
//                 existingAuthor.setCountry(book.getAuthor().getCountry());
//             }
//
//
//             book.setAuthor(existingAuthor);
//         }
//         return bookRepository.save(bookId);
//    }else{
//         throw new RuntimeException("data is not found");
//    }
//
//    }

}

//1 he must need a pen to write note
//2 he had to go with family but his musts go to office for
// argent work
//3n
//you must go to school
// you need money for buy a milk
// with who  you go shimla
//with whome to play cricket