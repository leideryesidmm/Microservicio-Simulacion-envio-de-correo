package com.nelumbo.mail.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimalDtoReq{
    @NotNull
    private Long id;
    @NotBlank
    private String specie;
    @NotBlank
    private String name;
}
