package com.nelumbo.mail.controller;

import com.nelumbo.mail.dto.res.WriterTopDtoRes;
import com.nelumbo.mail.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/writers")
@RequiredArgsConstructor
public class WriterController {
    private final WriterService writerService;
    @GetMapping("/top5")
    public List<WriterTopDtoRes> getTop5Writers() {
        return writerService.top5Writers();
    }
    @GetMapping("/top5/range-date")
    public List<WriterTopDtoRes> getTop5Writers(
            @RequestParam("startDate") String start,
            @RequestParam("endDate") String end) {
        return writerService.top5Writers(start, end);
    }
    @GetMapping("/top5/year")
    public List<WriterTopDtoRes> getTop5Writers(
            @RequestParam("year") int year) {
        return writerService.top5Writers(year);
    }
    @GetMapping("/top5/month")
    public List<WriterTopDtoRes> getTop5Writers(
            @RequestParam("year") int year,
            @RequestParam("month") int month) {
        return writerService.top5Writers(year,month);
    }
    @GetMapping("/top5/day")
    public List<WriterTopDtoRes> getTop5Writers(
            @RequestParam("date") String date) {
        return writerService.top5Writers(date);
    }
}
