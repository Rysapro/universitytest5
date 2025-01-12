package com.beinen.universitytest5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyNotFoundException extends RuntimeException {

    public FacultyNotFoundException(Long facultyId, Long universityId) {
        super(String.format("Faculty with id '%s' not found id ", facultyId, universityId));
    }
}
