package com.example.Sender;

import com.example.Message.Message;
import com.example.MessageService.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;


@Service
public class MessageSender {

    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private int threadId;

    private final RestTemplate restTemplate;
    private final MessageService messageService;

    public MessageSender(RestTemplate restTemplate, MessageService messageService) {
        this.restTemplate = restTemplate;
        this.messageService = messageService;
    }

    @Async
    public void send() {

        while(true) {

            try {

                Message message  = messageService.createNewMessage();

                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                HttpEntity<Message> entity = new HttpEntity<Message>(message,headers);

                if (message.getAction() == "PURCHASE")
                    restTemplate.exchange("http://localhost:8080/purchase", HttpMethod.POST, entity, String.class);
                    else
                        restTemplate.exchange("http://localhost:8080/subscription", HttpMethod.POST, entity, String.class);


                logger.info("Thread\t"+Thread.currentThread().getName() +"\tsended\t"+ message.toString());

                Thread.sleep(1000);

            } catch (InterruptedException e) {
            } catch (ResourceAccessException e) {
                logger.info("!!! FIRST RUN SUBSCRIBER JAR !!!");
                break;
            }
        }
    }
}


