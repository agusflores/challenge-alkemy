package com.demo.challengealkemy.repository.interfaces;

import com.demo.challengealkemy.model.Continent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends CrudRepository<Continent, Long> {

}
