package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import com.example.demo.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService ;

    @GetMapping
    public List<JournalEntry> getAll(){
       return journalEntryService.getAll() ;
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED ) ;
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST ) ;
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> entry =  journalEntryService.findById(myId)  ;
        if(entry.isPresent()){
            return  new ResponseEntity<>(entry.get(), HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }


    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
         journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId myId , @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(myId).orElse(null) ;
        if(old!=null){
            old.setTitle(newEntry!=null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry!=null && !newEntry.getContent().equals("") ? newEntry.getContent(): old.getContent());
            journalEntryService.saveEntry(old);
            return  new ResponseEntity<>(old, HttpStatus.OK) ;

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;

    }
}
