package com.beinen.universitytest5.service;

import com.beinen.universitytest5.model.Faculty;

public interface FacultyService {
    Faculty validateAndGetFaculty(Long facultyId, Long universityId);

    Faculty saveFaculty(Faculty faculty);

    void deleteFaculty(Faculty faculty);
}