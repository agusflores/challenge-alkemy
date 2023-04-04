package com.demo.challengealkemy.service.interfaces;


import com.demo.challengealkemy.model.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {

    ArrayList<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmailAndPassword(String email, String password);
    Boolean emailExists(String email);
    User saveUser(User u);
    boolean deleteByUser(Long id);
}
