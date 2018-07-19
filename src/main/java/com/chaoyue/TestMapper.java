package com.chaoyue;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestMapper {
    @Autowired
    private MongoTemplate mongoTemplate;


    public TestDto getById(String id) {
        return mongoTemplate.findById(id, TestDto.class);
    }


    public List<TestDto> getList(TestDto testDto) {
        if (testDto == null) {
            return mongoTemplate.findAll(TestDto.class);
        }
        Criteria criteria = new Criteria();
        criteria.and("name").is(testDto.getName());
        Query query = new Query(criteria);
        return mongoTemplate.find(query, TestDto.class);
    }


    public PageInfo<TestDto> getPage(TestDto testDto, int pageNo, int pageSize) {
        return null;
    }


    public String add(TestDto testDto) {
        mongoTemplate.insert(testDto);
        return null;
    }


    public void update(TestDto testDto) {

    }


    public void deleteById(String id) {

    }
}
