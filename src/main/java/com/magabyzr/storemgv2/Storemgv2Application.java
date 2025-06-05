package com.magabyzr.storemgv2;

import com.magabyzr.storemgv2.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Storemgv2Application {
    public static void main(String[] args) {
        //ApplicationContext context = SpringApplication.run(Storemgv2Application.class, args);
        var user = User.builder()
                .name("Daniel")
                .password("1234")
                .email("daniel@gmail.com")
                .build();
    }
}
