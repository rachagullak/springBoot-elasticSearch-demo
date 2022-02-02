package com.demo.springelasticdemo.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;
import lombok.ToString;

import static org.springframework.data.elasticsearch.annotations.FieldType.Nested;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "uid",
        "password",
        "first_name",
        "last_name",
        "username",
        "email",
        "avatar",
        "gender",
        "phone_number",
        "social_insurance_number",
        "date_of_birth",
        "event_type",
        "address",
        "credit_card",
        "subscription"
})
@Data
@ToString
@Document(indexName="user_profile", createIndex = false)
public class Photographer {

    @JsonProperty("id")
    @Id
    private Integer id;
    @JsonProperty("uid")
    @Field(type = Text)
    private String uid;
    @JsonProperty("first_name")
    @Field(name="first_name", type = Text)
    private String firstName;
    @JsonProperty("last_name")
    @Field(name="last_name", type = Text)
    private String lastName;
    @JsonProperty("username")
    @Field(type = Text)
    private String userName;
    @JsonProperty("email")
    @Field(type = Text)
    private String email;
    @JsonProperty("avatar")
    @Field(type = Text)
    private String avatar;
    @JsonProperty("gender")
    @Field(type = Text)
    private String gender;
    @JsonProperty("phone_number")
    @Field(name="phone_number", type = Text)
    private String phoneNumber;
    @JsonProperty("social_insurance_number")
    @Field(name="social_insurance_number", type = Text)
    private String socialInsuranceNumber;
    @JsonProperty("date_of_birth")
    @Field(name="date_of_birth", type = Text)
    private String dateOfBirth;
    @JsonProperty("event_type")
    @Field(name="event_type", type = Text, includeInParent = true)
    private EventType eventType;
    @JsonProperty("address")
    @Field(type = Nested, includeInParent = true)
    private Address address;
    @JsonProperty("credit_card")
    @Field(name="credit_card", type = Nested, includeInParent = true)
    private CreditCard creditCard;
    @JsonProperty("subscription")
    @Field(type = Nested, includeInParent = true)
    private Subscription subscription;

}