package com.beinen.universitytest5.rest.dto;

import java.util.List;

public record FacultyResponse(Long id, String name, List<StudentResponse> student)  {
}