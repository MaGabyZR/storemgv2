package com.magabyzr.storemgv2.services;

import com.magabyzr.storemgv2.entities.Address;
import com.magabyzr.storemgv2.entities.Product;
import com.magabyzr.storemgv2.entities.User;
import com.magabyzr.storemgv2.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    @Getter
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(3).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        productRepository.deleteById(4L);
    }

    @Transactional
    public void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
    }

/*    public void fetchProducts() {
        var products = productRepository.findByCategory(new Category((byte)1));
        products.forEach(System.out::println);
    }*/
    @Transactional
    public void fetchProducts() {
        //Query by example, and then pass it to our repository, and change it to JPARepository.
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(System.out::println);

/*        var products = productRepository.findProducts(BigDecimal.valueOf(1), BigDecimal.valueOf(15));
        products.forEach(System.out::println);*/    //Replaced by Query by example.
    }

    //Query using Criteria API.
    public void fetchProductsByCriteria(){
        var products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUser(){
        var user = userRepository.findByEmail("daniel@gmail.com").orElseThrow();
        System.out.println(user.getId());
    }

    //To avoid the N+1 problem
    @Transactional
    public void fetchUsers(){
        var users = userRepository.findAllWithTags();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void printLoyalProfiles(){
        var users = userRepository.findLoyalUsers(2);
        users.forEach(p -> System.out.println(p.getId() + ": " + p.getEmail()));
    }

}
