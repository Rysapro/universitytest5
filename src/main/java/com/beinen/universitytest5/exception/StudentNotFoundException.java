package com.beinen.universitytest5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long studentId, Long facultyId) {
        super(String.format("Student with id '%s' not found id ", studentId,  facultyId));
    }
}
