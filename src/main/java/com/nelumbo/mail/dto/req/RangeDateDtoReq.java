package com.nelumbo.mail.dto.req;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RangeDateDtoReq {
    private LocalDateTime ini;
    private LocalDateTime fin;
}
