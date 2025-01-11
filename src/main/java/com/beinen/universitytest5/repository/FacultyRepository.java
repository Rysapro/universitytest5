package com.beinen.universitytest5.repository;

import com.beinen.universitytest5.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository  extends JpaRepository<Faculty, Long> {
}