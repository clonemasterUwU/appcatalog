package moh.fa2021.cse201f.g4.appcatalogdemo.services;

import moh.fa2021.cse201f.g4.appcatalogdemo.models.App;
import moh.fa2021.cse201f.g4.appcatalogdemo.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    private AppRepository appRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<App> search(String name, String org, Pageable pageable) {
        org.springframework.data.mongodb.core.query.Query query = (name != null && !name.isBlank()) ? TextQuery.queryText(new TextCriteria().matching(name)).sortByScore().with(pageable) :
                new org.springframework.data.mongodb.core.query.Query().with(pageable);
        if (org != null) {
            query.addCriteria(Criteria.where("org").is(org));
        }
        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, App.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), App.class)).toList();
    }

    public App approve(App app){
        app.setApproveStatus(true);
        return appRepository.save(app);
    }
}

