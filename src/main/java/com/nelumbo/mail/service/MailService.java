package com.nelumbo.mail.service;

import com.nelumbo.mail.dto.MailDtoReq;
import com.nelumbo.mail.dto.MessageDtoRes;
import com.nelumbo.mail.model.Mail;
import com.nelumbo.mail.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailRepository mailRepository;
    private static final Logger logger= LoggerFactory.getLogger(MailService.class);
    public MessageDtoRes sendMail(MailDtoReq mailDtoReq){
        System.out.println(mailDtoReq);

        String mail="\nMail enviado a:"
                + mailDtoReq.getDestinationEmail()
                +"\n"
                +"Hay un nuevo comentario de "
                +mailDtoReq.getWriter().getName()
                +", al animal "
                +mailDtoReq.getAnimal().getSpecie()+" "+mailDtoReq.getAnimal().getName()
                +". \n"
                +"Comentario: "+mailDtoReq.getMessage();
        logger.info(mail);

        Mail saveMail=new Mail();
        saveMail.setAnimal(mailDtoReq.getAnimal().getId());
        saveMail.setWriter(mailDtoReq.getWriter().getId());
        saveMail.setMessage(mailDtoReq.getMessage());
        saveMail.setDestinationEmail(mailDtoReq.getDestinationEmail());

        saveMail=mailRepository.save(saveMail);
        return new MessageDtoRes("Email enviado, con el id: " + saveMail.getId());
    }
}