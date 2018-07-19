package com.chaoyue.mongo.test;

import com.chaoyue.TestDto;
import com.chaoyue.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MongoQueryTest extends AbstractSpringContextTest {
    @Autowired
    private TestService testService;

    @Test
    public void getAllTest() {
        List<TestDto> resultList = testService.getAll();
        System.out.println(resultList);
    }

    @Test
    public void getByIdTest() {
        TestDto testDto = testService.getById("5b50242fbdd62c9ed416e613");
        System.out.println(testDto);
    }

    @Test
    public void updateTest() {
        TestDto testDto = new TestDto();
        testDto.setName("chaoyue");
        testDto.setAge(18);
        testService.update(testDto);
    }

    @Test
    public void addTest() {
        TestDto testDto = new TestDto();
        testDto.setName("chaoyue2");
        testDto.setAge(20);
        testService.add(testDto);
    }

    @Test
    public void deleteTest() {
        testService.delete();
    }
}
