package com.example.Runner;

import com.example.Sender.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    private final MessageSender messageSender;

    public AppRunner(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Start sending");

        messageSender.send();
        messageSender.send();
        messageSender.send();
        messageSender.send();
        messageSender.send();

    }
}
