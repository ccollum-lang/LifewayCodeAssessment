package com.example.lifewaycodeassessment.model;

import javax.persistence.*;

@Entity
@Table
public class Message {
    @Id
    @Column
    private String id;

    @Column
    private String message;

    // Constructor, getters and setters
    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message(){}

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

}
