package com.acme.openworldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OpenWorldApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenWorldApiApplication.class, args);
    }

}
