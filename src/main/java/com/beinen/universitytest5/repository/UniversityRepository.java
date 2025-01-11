package com.beinen.universitytest5.repository;

import com.beinen.universitytest5.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}