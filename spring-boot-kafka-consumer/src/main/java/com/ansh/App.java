package com.ansh;

import com.ansh.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class App {

    @Autowired
    private ConsumerService consumerService;

    public static void main(String[] args) {
        log.info("App is starting");
        SpringApplication.run(App.class, args);
    }
}