package com.magabyzr.storemgv2;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final com.magabyzr.storemgv2.UserRepository userRepository;
    private final com.magabyzr.storemgv2.NotificationService notificationService;

    public UserService(com.magabyzr.storemgv2.UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }

        userRepository.save(user);
        notificationService.send("You registered successfully!", user.getEmail());
    }
}
