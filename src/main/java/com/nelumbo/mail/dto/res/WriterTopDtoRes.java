package com.nelumbo.mail.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriterTopDtoRes {
    private Long id;
    private String name;
    private Integer count;
}