package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.dtos.UserSummary;
import com.magabyzr.storemgv2.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}