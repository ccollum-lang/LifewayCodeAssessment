package com.example.lifewaycodeassessment.service;

import com.example.lifewaycodeassessment.model.Message;
import com.example.lifewaycodeassessment.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    // getting all messages
    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<Message>();
        messageRepository.findAll().forEach(message -> messages.add(message));
        return messages;
    }

    public Optional<Message> getMessageByID(String id) {
        return messageRepository.findById(id);
    }

    public void saveOrUpdate(Message message) {
        messageRepository.save(message);
    }
}
