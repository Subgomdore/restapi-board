package com.project.restapiboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestapiBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiBoardApplication.class, args);
    }

}
