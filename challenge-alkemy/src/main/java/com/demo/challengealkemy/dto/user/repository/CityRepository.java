package com.demo.challengealkemy.dto.user.repository;

import com.demo.challengealkemy.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<User, Long> {
}
