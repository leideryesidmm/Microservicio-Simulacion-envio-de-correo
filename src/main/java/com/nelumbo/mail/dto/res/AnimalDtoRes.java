package com.nelumbo.mail.dto.res;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimalDtoRes {
    private Long id;
    private String species;
    private String name;
}
