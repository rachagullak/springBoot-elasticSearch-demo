package com.demo.springelasticdemo.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreditCard {

    @JsonProperty("cc_number")
    private String ccNumber;

}