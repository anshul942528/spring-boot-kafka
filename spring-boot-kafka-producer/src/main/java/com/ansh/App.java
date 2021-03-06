package com.ansh;

import com.ansh.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {

    @Autowired
    private ProducerService producerService;

    public static void main(String[] args) {
        log.info("App is starting");
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Command line runner example");
        producerService.sendKafkaMessage("third");
    }
}
