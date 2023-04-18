package com.demo.challengealkemy.repository.interfaces;

import com.demo.challengealkemy.model.Icon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface IconRepository extends CrudRepository<Icon, Long> {
    ArrayList<Icon> findByDenomination(String denomination);
    ArrayList<Icon> findByCreation(Date creation);
    ArrayList<Icon> findByCityId(Long id);
}
