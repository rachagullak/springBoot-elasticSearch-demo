package com.demo.springelasticdemo.data.model;

import lombok.Data;

@Data
public class PhotographerResponseDto {

    private String firstName;
    private String lastName;
    private String avatar;
    private String phoneNumber;
    private Address address;
}
