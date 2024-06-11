package com.sctpl.admin.g1.library123.repository;

import com.sctpl.admin.g1.library123.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(nativeQuery = true,value = "select * from book where bookId=?")
    Book fetchById(@Param("bookId") Integer bookId);             // transaction return

    @Query(nativeQuery = true,value = "select * from book where bookName=?")
    Book fetchByName(@Param("bookName") String bookName);


//    @Modifying
//    @Query("update book b set b.card = :#{#book.cardId}, b.available = :#{#book.available} where b.bookId = :#{#book.bookId}")
//    int updateBook(@Param("book") Book bookId);
//
//
//
//    @Query("select b from book b where b.genre=:genre and b.available=:available and b.name in (select a from author a where a.name=:name)")
//    List<Book> findBooksByGenre_Author(@Param("genre") String genre, @Param("name") String author, @Param("available") boolean available);
//
//    @Query("select b from book b where b.genre=:genre and b.available=:available")
//    List<Book> findBooksByGenre(@Param("genre") String genre,@Param("available") boolean available);
//
//    @Query("select b from book b where b.available=:available and b.author in(select a from author a where a.name=:name)")
//    List<Book> findBooksByAuthor(@Param("name") String author,@Param("available") boolean available);
//
//    @Query("select b from book b where b.available=:available")
//    List<Book> findBooksByAvailability(@Param("available") boolean available);
}
