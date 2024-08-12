package com.nelumbo.mail.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimalDtoReq{
    @NotNull
    private Long id;
    @NotBlank
    private String species;
    @NotBlank
    private String name;
}
