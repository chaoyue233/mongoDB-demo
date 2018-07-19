package com.chaoyue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<TestDto> getAll() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        return mongoTemplate.find(query, TestDto.class);
    }

    public TestDto getById(String id) {
        return mongoTemplate.findById(id, TestDto.class);
    }

    public void add(TestDto testDto) {
        mongoTemplate.insert(testDto, "test_coll");
    }

    public void update(TestDto testDto) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("name").is(testDto.getName()));
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("age", testDto.getAge());
        mongoTemplate.updateMulti(query, update, TestDto.class);
    }

    public void delete() {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("name").is("chaoyue2"));
        Query query = new Query(criteria);
        mongoTemplate.remove(query, "test_coll");
    }
}
