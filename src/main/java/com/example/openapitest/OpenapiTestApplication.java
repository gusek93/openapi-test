package com.example.openapitest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OpenapiTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(OpenapiTestApplication.class, args);
        log.debug("http://localhost:8080/swagger-ui.html");
    }

}
