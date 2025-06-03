package com.magabyzr.storemgv2;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Storemgv2Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Storemgv2Application.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L, "gaby@gmail.com", "12345", "MaGaby"));
    }
}
