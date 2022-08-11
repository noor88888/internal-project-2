package com.convertion2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.convertion2.model.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {

}
