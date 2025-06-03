package com.magabyzr.storemg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class StoremgApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoremgApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L, "gaby@gmail.com", "12345", "MaGaby"));
    }

}
