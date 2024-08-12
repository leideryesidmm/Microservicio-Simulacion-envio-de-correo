package com.nelumbo.mail.dto.res;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MailDtoRes {
    private String id;
    private String destinationEmail;
    private AnimalDtoRes animal;
    private WriterDtoRes writer;
    private String message;
    private LocalDateTime date;
}
