package com.sctpl.admin.g1.library123.repository;


import com.sctpl.admin.g1.library123.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    //        @Query(nativeQuery = true,value = "SELECT * FROM transactions WHERE books_id = ? AND students_id = ?")
//    Transaction findByBooks_idAndStudents_id(Integer books_id, Integer students_id);

    @Query(nativeQuery = true,value = "select * from Transaction where student_id")
    Transaction findByStudent_id(Integer student_id);
}
