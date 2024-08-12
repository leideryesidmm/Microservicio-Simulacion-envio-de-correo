package com.nelumbo.mail.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "mails")
@JsonPropertyOrder({"id", "destinationEmail","animal","writer","message"})
public class Mail {
    @Id
    @NotNull
    private String id;
    @NotBlank
    private String destinationEmail;
    @NotNull
    private Animal animal;
    @NotBlank
    private Writer writer;
    @NotBlank
    private String message;
    @NotNull
    private LocalDateTime date;
}
