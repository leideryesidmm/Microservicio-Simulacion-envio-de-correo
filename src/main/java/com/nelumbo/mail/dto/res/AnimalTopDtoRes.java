package com.nelumbo.mail.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalTopDtoRes {
    private Long id;
    private String species;
    private String name;
    private Integer count;
}
