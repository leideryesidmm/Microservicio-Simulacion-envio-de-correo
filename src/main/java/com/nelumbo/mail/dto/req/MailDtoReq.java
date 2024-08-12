package com.nelumbo.mail.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;


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
    @NotNull
    private LocalDateTime date;
}