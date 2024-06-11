package com.sctpl.admin.g1.library123.repository;

import com.sctpl.admin.g1.library123.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(nativeQuery = true,value="select * from author where authorId=?")
    Author fetchById(String authorId);

}
