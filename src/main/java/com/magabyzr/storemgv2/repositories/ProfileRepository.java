package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}