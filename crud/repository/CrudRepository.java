package com.sctpl.admin.g1.crud.repository;

import com.sctpl.admin.g1.crud.domain.Crud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository extends JpaRepository<Crud,Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "delete from crud where crudId = :crudId")
    void deleteByCrudId(@Param("crudId") Integer crudId);

    @Query(nativeQuery = true,value="select * from crud where crudId=?")
    Crud findByCrudId(@Param("crudId") Integer crudId);
}
