package com.sctpl.admin.g1.library123.repository;

import com.sctpl.admin.g1.library123.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(nativeQuery = true,value="select * from student where studentId = ?")
    Student fetchById(Integer studentId);

    @Query(nativeQuery = true,value="select * from student where students_id = ?")
    Student fetchByStudentId(@Param("students_id") Integer students_id);  //transaction class issue
}
