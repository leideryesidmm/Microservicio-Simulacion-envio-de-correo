package com.nelumbo.mail.controller;

import com.nelumbo.mail.dto.res.AnimalTopDtoRes;
import com.nelumbo.mail.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
    @GetMapping("/top5")
    public List<AnimalTopDtoRes> getTop5Writers() {
        return animalService.top5Animals();
    }
    @GetMapping("/top5/range-date")
    public List<AnimalTopDtoRes> getTop5Animals(
            @RequestParam("startDate") String start,
            @RequestParam("endDate") String end) {
        return animalService.top5Animals(start, end);
    }
    @GetMapping("/top5/year")
    public List<AnimalTopDtoRes> getTop5Animals(
            @RequestParam("year") int year) {
        return animalService.top5Animals(year);
    }
    @GetMapping("/top5/month")
    public List<AnimalTopDtoRes> getTop5Animals(
            @RequestParam("year") int year,
            @RequestParam("month") int month) {
        return animalService.top5Animals(year,month);
    }
    @GetMapping("/top5/day")
    public List<AnimalTopDtoRes> getTop5Animals(
            @RequestParam("date") String date) {
        return animalService.top5Animals(date);
    }
}
