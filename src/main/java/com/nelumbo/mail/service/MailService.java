package com.nelumbo.mail.service;

import com.nelumbo.mail.dto.req.MailDtoReq;
import com.nelumbo.mail.dto.res.*;
import com.nelumbo.mail.model.Animal;
import com.nelumbo.mail.model.Mail;
import com.nelumbo.mail.model.Writer;
import com.nelumbo.mail.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailRepository mailRepository;
    private final ModelMapper modelMapper;
    private static String [] monthsNames={
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    private static final Logger logger= LoggerFactory.getLogger(MailService.class);
    public MessageDtoRes sendMail(MailDtoReq mailDtoReq){
        String mail="\nMail enviado a:"
                + mailDtoReq.getDestinationEmail()
                +"\n"
                +"Hay un nuevo comentario de "
                +mailDtoReq.getWriter().getName()
                +", al animal "
                +mailDtoReq.getAnimal().getSpecies()+" "+mailDtoReq.getAnimal().getName()
                +". \n"
                +"Comentario: "+mailDtoReq.getMessage();
        logger.info(mail);
        MailDtoRes messageDtoRes=saveMail(mailDtoReq);
        return new MessageDtoRes("Email enviado, con el id: " + messageDtoRes.getId());
    }
    public MailDtoRes saveMail(MailDtoReq mailDtoReq){
        Mail saveMail=new Mail();
        saveMail.setAnimal(modelMapper.map(mailDtoReq.getAnimal(), Animal.class));
        saveMail.setWriter(modelMapper.map(mailDtoReq.getWriter(), Writer.class));
        saveMail.setMessage(mailDtoReq.getMessage());
        saveMail.setDate(mailDtoReq.getDate());
        saveMail.setDestinationEmail(mailDtoReq.getDestinationEmail());

        return modelMapper.map(mailRepository.save(saveMail),MailDtoRes.class);
    }

    public MonthsDtoReq getAmountCommentsAndAnswersByMonth(int year){
        List<MothDtoRes> month=new ArrayList<>();
        int cant=0;
        for(int i=0;i<12;i++){
            LocalDateTime ini=LocalDateTime.of(LocalDate.of(year,i+1,1), LocalTime.of(0,0,0));
            YearMonth yearMonth=YearMonth.of(year,i+1);
            LocalDateTime fin=yearMonth.atEndOfMonth().atTime(23,59,59);
            System.out.println(ini);
            System.out.println(fin);
            MothDtoRes mothDtoRes=new MothDtoRes();
            mothDtoRes.setMonth(monthsNames[i]);
            mothDtoRes.setAmount(mailRepository.countByDateBetween(ini,fin));
            cant+=mothDtoRes.getAmount();
            month.add(mothDtoRes);
        }
        System.out.println(cant);
        MonthsDtoReq monthsDtoReq=new MonthsDtoReq();
        monthsDtoReq.setMonths(month);
        monthsDtoReq.setYear(year);
        return monthsDtoReq;
    }

}