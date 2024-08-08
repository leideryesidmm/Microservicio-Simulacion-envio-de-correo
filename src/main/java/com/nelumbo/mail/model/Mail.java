package com.nelumbo.mail.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nelumbo.mail.dto.AnimalDtoReq;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private Long animal;
    @NotBlank
    private Long writer;
    @NotBlank
    private String message;
}
