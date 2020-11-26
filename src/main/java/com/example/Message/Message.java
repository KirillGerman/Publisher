package com.example.Message;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Message {

    private int id;
    private int msisdn;
    private String action;
    private LocalDateTime timestamp;

    public Message(int id, int msisdn, String action, LocalDateTime timestamp) {
        this.id = id;
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
