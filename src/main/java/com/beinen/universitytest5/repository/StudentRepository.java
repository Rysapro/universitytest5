package com.beinen.universitytest5.repository;

import com.beinen.universitytest5.model.Faculty;
import com.beinen.universitytest5.model.Student;
import com.beinen.universitytest5.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository  extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndFacultyId(Long id, Long facultyId);

}