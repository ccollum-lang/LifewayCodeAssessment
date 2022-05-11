package com.example.lifewaycodeassessment.repository;

import com.example.lifewaycodeassessment.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,String> {}
