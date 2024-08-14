package com.example.notify.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user-data") 
public class User {

    @Id
    private String id; 

    @Field(name = "email")
    private String email;

    @Field(name = "artist")
    private String artistName;

    @Field(name = "city")
    private String city;

}
