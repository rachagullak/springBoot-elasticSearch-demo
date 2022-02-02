package com.demo.springelasticdemo.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.data.elasticsearch.annotations.Field;

import javax.annotation.Generated;

import lombok.Data;

import static org.springframework.data.elasticsearch.annotations.FieldType.Nested;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "city",
        "street_name",
        "street_address",
        "zip_code",
        "state",
        "country",
        "coordinates"
})
@Generated("jsonschema2pojo")
@Data
public class Address {

    @JsonProperty("city")
    @Field(type = Text)
    private String city;
    @JsonProperty("street_name")
    @Field(name="street_name", type = Text)
    private String streetName;
    @JsonProperty("street_address")
    @Field(name="street_address", type = Text)
    private String streetAddress;
    @JsonProperty("zip_code")
    @Field(name="zip_code", type = Text)
    private String zipCode;
    @JsonProperty("state")
    @Field(type = Text)
    private String state;
    @JsonProperty("country")
    @Field(type = Text)
    private String country;
    @JsonProperty("coordinates")
    @Field(type = Nested, includeInParent = true)
    private Coordinates coordinates;

}