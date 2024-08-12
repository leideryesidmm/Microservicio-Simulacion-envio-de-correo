package com.nelumbo.mail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "writers")
@Data
public class Writer {
    private Long id;
    private String name;
}
