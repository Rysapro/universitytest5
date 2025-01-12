package com.beinen.universitytest5.rest.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateStudentRequest(@NotBlank String name) {
}
