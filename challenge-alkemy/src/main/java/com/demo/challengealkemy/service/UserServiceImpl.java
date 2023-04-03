package com.demo.challengealkemy.service;

import com.demo.challengealkemy.helper.ApiHelper;
import com.demo.challengealkemy.model.User;
import com.demo.challengealkemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) repository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> u = repository.findById(id);
        if (u.isPresent()) {
            return u;
        }
        return null;
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        Optional<User> u = repository.findByEmailAndPassword(email, password);
        return u;
    }

    @Override
    public Boolean emailExists(String email) {
        Optional<User> u = repository.findByEmail(email);
        return u.isPresent();
    }

    @Override
    public User saveUser(User u) {
        return repository.save(u);
    }

    @Override
    public boolean deleteByUser(Long id) {
        Optional<User> u = repository.findById(id);
        if (u.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}


