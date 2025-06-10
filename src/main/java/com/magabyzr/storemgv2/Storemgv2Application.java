package com.magabyzr.storemgv2;

import com.magabyzr.storemgv2.entities.Address;
import com.magabyzr.storemgv2.entities.Profile;
import com.magabyzr.storemgv2.entities.Tag;
import com.magabyzr.storemgv2.entities.User;
import com.magabyzr.storemgv2.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Storemgv2Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Storemgv2Application.class, args);
        var repository = context.getBean(UserRepository.class);

        var user = User.builder()
                .name("Daniel")
                .password("1234")
                .email("daniel@gmail.com")
                .build();

        repository.save(user);

       /* var address = Address.builder()
                .street("123 Main St")
                .city("Main St")
                .state("Main St")
                .zip("1234")
                .build();

        user.addAddress(address);*/

        //user.addTag("tag1");

/*        var profile = Profile.builder()
                        .bio("Daniel blah blah blah")
                                .build();

        user.setProfile(profile);
        profile.setUser(user);

        System.out.println(user);*/


    }
}
