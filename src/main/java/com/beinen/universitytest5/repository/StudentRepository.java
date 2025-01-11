package com.beinen.universitytest5.repository;

import com.beinen.universitytest5.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long> {
}