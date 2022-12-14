package com.project.restapiboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestapiBoardApplication extends SpringBootServletInitializer {

    //    public static void main(String[] args) {
//        SpringApplication.run(RestapiBoardApplication.class, args);
//    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(RestapiBoardApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestapiBoardApplication.class, args);
    }

}
