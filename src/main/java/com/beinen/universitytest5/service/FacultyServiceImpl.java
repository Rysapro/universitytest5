package com.beinen.universitytest5.service;

import com.beinen.universitytest5.exception.FacultyNotFoundException;
import com.beinen.universitytest5.model.Faculty;
import com.beinen.universitytest5.repository.FacultyRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty validateAndGetFaculty(Long facultyId, Long universityId) {
        return facultyRepository.findByIdAndUniversityId(facultyId, universityId)
                .orElseThrow(()->new FacultyNotFoundException(facultyId, universityId));
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        facultyRepository.delete(faculty);
    }
}