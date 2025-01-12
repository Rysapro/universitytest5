package com.beinen.universitytest5.service;

import com.beinen.universitytest5.exception.UniversityNotFoundException;
import com.beinen.universitytest5.model.University;
import com.beinen.universitytest5.repository.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University validateAndGetUniversity(Long id) {
        return universityRepository.findById(id).orElseThrow(() -> new UniversityNotFoundException(id));
    }

    @Override
    public University saveUniversity(University university) {
        return universityRepository.save(university);
    }




}