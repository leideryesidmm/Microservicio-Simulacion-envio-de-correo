package com.nelumbo.mail.service;

import com.nelumbo.mail.dto.res.WriterTopDtoRes;
import com.nelumbo.mail.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WriterService {
    private final MailRepository mailRepository;

    public List<WriterTopDtoRes> top5Writers(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate parsedDate = LocalDate.parse(date, formatter);

        LocalDateTime ini = parsedDate.atStartOfDay();
        LocalDateTime fin = parsedDate.atTime(LocalTime.MAX);

        System.out.println(ini);
        System.out.println(fin);

        return this.mailRepository.findTop5WritersByMessageCountWithinDateRange(ini,fin);
    }
    public List<WriterTopDtoRes> top5Writers(int year,int month){
        LocalDateTime ini=LocalDateTime.of(year,month,1,0,0,0);
        YearMonth yearMonth=YearMonth.of(year,month);
        LocalDateTime fin=yearMonth.atEndOfMonth().atTime(23,59,59);

        System.out.println(ini);
        System.out.println(fin);
        return this.mailRepository.findTop5WritersByMessageCountWithinDateRange(ini,fin);
    }
    public List<WriterTopDtoRes> top5Writers(int year){
        LocalDateTime ini=LocalDateTime.of(year,1,1,0,0,0);
        LocalDateTime fin=LocalDateTime.of(year,12,31,23,59,50);

        System.out.println(ini);
        System.out.println(fin);
        return this.mailRepository.findTop5WritersByMessageCountWithinDateRange(ini,fin);
    }
    public List<WriterTopDtoRes> top5Writers(){
        return this.mailRepository.findTop5WritersByMessageCount();
    }
    public List<WriterTopDtoRes> top5Writers(String ini, String fin){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(ini, formatter);
        LocalDateTime end = LocalDateTime.parse(fin, formatter);

        System.out.println(ini);
        System.out.println(fin);
        return this.mailRepository.findTop5WritersByMessageCountWithinDateRange(start,end);
    }


}
