package com.nelumbo.mail.controller;

import com.nelumbo.mail.dto.MailDtoReq;
import com.nelumbo.mail.dto.MessageDtoRes;
import com.nelumbo.mail.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mails")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public MessageDtoRes createCommentOrAnswer(@Valid @RequestBody MailDtoReq mailDtoReq) {
        return mailService.sendMail(mailDtoReq);
    }
}
