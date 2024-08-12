package com.nelumbo.mail.dto.res;

import lombok.Data;

import java.util.List;

@Data
public class MonthsDtoReq {
    private List<MothDtoRes> months;
    private int year;
}
