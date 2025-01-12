package com.beinen.universitytest5.repository;

import com.beinen.universitytest5.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository  extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByIdAndUniversityId(Long id, Long universityId);


}