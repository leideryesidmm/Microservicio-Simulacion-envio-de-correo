package com.nelumbo.mail.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MailDtoReq {
    @NotBlank
    private String destinationEmail;
    @NotNull
    private AnimalDtoReq animal;
    @NotNull
    private WriterDtoReq writer;
    @NotBlank
    private String message;
}