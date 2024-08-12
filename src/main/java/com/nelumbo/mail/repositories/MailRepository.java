package com.nelumbo.mail.repositories;

import com.nelumbo.mail.dto.res.AnimalTopDtoRes;
import com.nelumbo.mail.dto.res.WriterDtoRes;
import com.nelumbo.mail.dto.res.WriterTopDtoRes;
import com.nelumbo.mail.model.Mail;
import com.nelumbo.mail.model.Writer;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MailRepository extends MongoRepository<Mail,String> {
    int countByDateBetween(LocalDateTime ini, LocalDateTime fin);
    List<Mail> findByDateBetween(LocalDateTime ini, LocalDateTime fin);

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$writer', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$limit': 5 }",
            "{ $project: { '_id': 0, id:'$_id._id', name: '$_id.name', 'count': 1 } }"
    })
    List<WriterTopDtoRes> findTop5WritersByMessageCount();
    @Aggregation(pipeline = {
            "{ '$match': { 'date': { '$gte': ?0, '$lte': ?1 } } }",
            "{ '$group': { '_id': '$writer', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$limit': 5 }",
            "{ '$project': { '_id': 0, 'id': '$_id._id', 'name': '$_id.name', 'count': 1 } }"
    })
    List<WriterTopDtoRes> findTop5WritersByMessageCountWithinDateRange(LocalDateTime startDate, LocalDateTime endDate);
    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$animal', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$limit': 5 }",
            "{ $project: { '_id': 0, id:'$_id._id','species': '$_id.species', name: '$_id.name', 'count': 1 } }"
    })
    List<AnimalTopDtoRes> findTop5AnimalsByMessageCount();
    @Aggregation(pipeline = {
            "{ '$match': { 'date': { '$gte': ?0, '$lte': ?1 } } }",
            "{ '$group': { '_id': '$animal', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$limit': 5 }",
            "{ '$project': { '_id': 0, 'id': '$_id._id', 'species': '$_id.species', 'name': '$_id.name', 'count': 1 } }"
    })
    List<AnimalTopDtoRes> findTop5AnimalsByMessageCountWithinDateRange(LocalDateTime startDate, LocalDateTime endDate);


}
