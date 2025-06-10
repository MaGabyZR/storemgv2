package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
