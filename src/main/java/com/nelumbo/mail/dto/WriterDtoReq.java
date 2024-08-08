package com.nelumbo.mail.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WriterDtoReq {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
}
