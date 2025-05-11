package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "journal_entries")
@Data
public class JournalEntry {


    private ObjectId id ;
    @NonNull
    private String title ;
    private String content ;
    private LocalDateTime date ;

    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>() ;

}
