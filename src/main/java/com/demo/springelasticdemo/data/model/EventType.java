package com.demo.springelasticdemo.data.model;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;

@Data
public class EventType {

    @Field(type = Keyword)
    private String[] type;

}