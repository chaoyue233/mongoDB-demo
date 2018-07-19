package com.chaoyue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<TestDto> getAll() {
        return testMapper.getList(null);
    }

    public TestDto getById(String id) {
        return testMapper.getById(id);
    }

    public void add(TestDto testDto) {
        testMapper.add(testDto);
    }

    public void update(TestDto testDto) {
//        Criteria criteria = new Criteria();
//        criteria.andOperator(Criteria.where("name").is(testDto.getName()));
//        Query query = new Query(criteria);
//        Update update = new Update();
//        update.set("age", testDto.getAge());
//        mongoTemplate.updateMulti(query, update, TestDto.class);
        testMapper.update(testDto);
    }

    public void deleteById(String id) {
//        Criteria criteria = new Criteria();
//        criteria.and("_id").is(id);
//        Query query = new Query(criteria);
//        mongoTemplate.remove(query, TestDto.class);
        testMapper.deleteById(id);
    }
}
