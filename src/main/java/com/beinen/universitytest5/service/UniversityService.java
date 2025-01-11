package com.beinen.universitytest5.service;

import com.beinen.universitytest5.model.University;

public interface UniversityService {
    University validateAndGetUniversity(Long id);

    University saveUniversity(University university);

}