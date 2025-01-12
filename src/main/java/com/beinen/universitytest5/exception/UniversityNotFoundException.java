package com.beinen.universitytest5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UniversityNotFoundException extends RuntimeException{

    public UniversityNotFoundException(Long id){
        super(String.format("University with id '%s' not found", id));
    }
}
