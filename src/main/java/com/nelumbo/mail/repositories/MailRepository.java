package com.nelumbo.mail.repositories;

import com.nelumbo.mail.model.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MailRepository extends MongoRepository<Mail,Long> {

}
