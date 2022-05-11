package com.example.lifewaycodeassessment.controller;

import com.example.lifewaycodeassessment.model.Count;
import com.example.lifewaycodeassessment.model.Message;
//import com.example.lifewaycodeassessment.repository.CountRepository;
import com.example.lifewaycodeassessment.repository.CountRepository;
import com.example.lifewaycodeassessment.service.CountService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.lifewaycodeassessment.service.MessageService;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.List;

// create RestController
@RestController
public class MessageController {
    // autowire the StudentService class
    @Autowired
    MessageService messageService;

    @Autowired
    CountService countService;

    // create a GET mapping that retrieves the message details from the database
    @GetMapping("/message")
    private List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }
    private List<Count> getAllCount() { return countService.getAllCount();}

    // create a POST mapping that posts the message detail in the database
    private void saveMessage(@RequestBody Message message) {
        messageService.saveOrUpdate(message);
    }

    private void saveCount (Count count) {
        countService.saveOrUpdate(count);
    }

    @PostMapping("/message")
    private String processMessage(@RequestBody Message message) {
        int totalCount = 0;
        boolean idExists = false;
        int instanceCount = countWords(message.getMessage());

        Count concurrentCount = new Count();
        String currentID = message.getId();
        List<Message> messages = getAllMessages();

        List<Count> countFromDB = getAllCount();

        //JSONParser parser = new JSONParser();

        for (Message value : messages) {
            if (currentID.equals(value.getId())) {
                idExists = true;
                break;
            }
        }
        int sum = 0;
        if (!idExists) {
            // save message and concurrent count to H2
            saveMessage(message);
            System.out.println("Message saved!");
            if (countFromDB.size() == 0) {
                concurrentCount.setCount(instanceCount);
                saveCount(concurrentCount);
            }else {
                for (int i = 0; i < countFromDB.size(); i++) {
                    sum += countFromDB.get(i).getCount();
                    concurrentCount.setCount(sum + instanceCount);
                }
                saveCount(concurrentCount);
            }
            return "Count = " + concurrentCount.getCount();
        } else {
            // ignore the message and return JSON Document
            System.out.println("ID exists!");
            return "ID already exists!";
        }
    }


    public static int countWords(String s) {
        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if char is letter, word = true
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
            // is char a letter && have there been words before?
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
            // last word of String;
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}