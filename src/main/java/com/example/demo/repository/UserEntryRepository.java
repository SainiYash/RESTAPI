package com.example.demo.repository;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<UserEntry, ObjectId> {
}
