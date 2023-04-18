package com.demo.challengealkemy.repository.interfaces;

import com.demo.challengealkemy.model.IconContinent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconContinentRepository extends CrudRepository<IconContinent, String> {

}
