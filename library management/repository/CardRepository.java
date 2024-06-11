package com.sctpl.admin.g1.library123.repository;

import com.sctpl.admin.g1.library123.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    @Query(nativeQuery = true,value="select * from card where cardId = ?")
    Card fetchById(Integer cardId);
}
