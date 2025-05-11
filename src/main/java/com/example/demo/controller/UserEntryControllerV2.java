package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import com.example.demo.service.JournalEntryService;
import com.example.demo.service.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserEntryControllerV2 {

       @Autowired
       private UserEntryService userEntryService ;

}
