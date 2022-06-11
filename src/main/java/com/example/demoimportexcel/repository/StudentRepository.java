package com.example.demoimportexcel.repository;

import com.example.demoimportexcel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    @Query("select s from Student s where s.name like %:name% and s.student_id like %:studentId%")
    List<Student> findByNameAndStudentId(@Param("name") String name,@Param("studentId") String studentId);
    @Query("select s from Student s where s.student_id like %:studentId%")
    List<Student> findByStudentId(@Param("studentId") String studentId);
    @Query("select s from Student s where s.name like %:name%")
    List<Student> findByName(@Param("name") String name);
}
