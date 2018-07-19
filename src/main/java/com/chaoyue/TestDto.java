package com.chaoyue;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@ToString
@Document(collection = "test_coll")
public class TestDto {
    @Field(value = "name")
    private String name;
    @Field(value = "age")
    private Integer age;
    @Field(value = "mail_address")
    private String mailAddress;
}
