package com.beinen.universitytest5.rest.dto;

import java.util.List;

public record UniversityResponse(Long id, String name, List<FacultyResponse> faculty) {
}