package com.example.MessageService;

import com.example.Message.Message;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MessageService {

    private static AtomicInteger counter = new AtomicInteger();
    Random random = new Random();

    public MessageService() {
    }

    public Message createNewMessage(){
        int  id = counter.getAndAdd(1);
        int  msisdn = random.nextInt(Integer.MAX_VALUE);
        String action = msisdn % 2 == 0 ? "PURCHASE" : "SUBSCRIPTION";
        LocalDateTime date = LocalDateTime.now();
        return new Message(id, msisdn, action, date);
    };


}
