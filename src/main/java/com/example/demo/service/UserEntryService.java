package com.example.demo.service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.UserEntry;
import com.example.demo.repository.JournalEntryRepository;
import com.example.demo.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserEntryService {

    @Autowired
    private UserEntryRepository userEntryRepository ;

    public  void saveEntry(UserEntry userEntry){
        userEntryRepository.save(userEntry) ;
    }

    public List<UserEntry> getAll(){
        return userEntryRepository.findAll();
    }

    public Optional<UserEntry> findById(ObjectId id){
        return userEntryRepository.findById(id) ;
    }

    public void deleteById(ObjectId id){
        userEntryRepository.deleteById(id);
    }


}
