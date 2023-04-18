package com.demo.challengealkemy.repository.interfaces;

import com.demo.challengealkemy.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
