package com.example.demo.entity;


import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class UserEntry {

    @Id
    private ObjectId id ;
    @Indexed(unique = true)
    @NonNull
    private String userName ;
    @NonNull
    private String userPassword ;

}
