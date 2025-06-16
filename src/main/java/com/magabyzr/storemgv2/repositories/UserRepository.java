package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);

    //avoid the N+1 problem
    @EntityGraph
    @Query("select u from User u")
    List<User> findAllWithTags();
}
