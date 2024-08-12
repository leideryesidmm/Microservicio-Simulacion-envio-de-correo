package com.nelumbo.mail.controller;

import com.nelumbo.mail.dto.req.MailDtoReq;
import com.nelumbo.mail.dto.res.MessageDtoRes;
import com.nelumbo.mail.dto.res.MonthsDtoReq;
import com.nelumbo.mail.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mails")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    @PostMapping("/send")
    public MessageDtoRes sendMail(@Valid @RequestBody MailDtoReq mailDtoReq) {
        return mailService.sendMail(mailDtoReq);
    }
    @GetMapping("/amount/{year}")
    public MonthsDtoReq getAmountCommentsAndAnswersByMonths(@PathVariable int year) {
        return mailService.getAmountCommentsAndAnswersByMonth(year);
    }




}
