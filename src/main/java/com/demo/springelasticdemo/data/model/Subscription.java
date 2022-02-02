package com.demo.springelasticdemo.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Data
public class Subscription {

    @Field(type = Text)
    private String plan;
    @Field(type = Text)
    private String status;
    @JsonProperty("payment_method")
    @Field(name="payment_method", type = Text)
    private String paymentMethod;
    @Field(type = Text)
    private String term;

}