package com.demo.springelasticdemo.data.model;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Data
public class Coordinates {

    @Field(type = Text)
    private Double lat;
    @Field(type = Text)
    private Double lng;

}