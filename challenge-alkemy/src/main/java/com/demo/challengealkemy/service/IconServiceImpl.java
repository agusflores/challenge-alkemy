package com.demo.challengealkemy.service;

import com.demo.challengealkemy.model.Icon;
import com.demo.challengealkemy.repository.IconRepository;
import com.demo.challengealkemy.service.interfaces.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconRepository repository;

    @Override
    public List<Icon> getAllIcons() {
        return (List<Icon>) repository.findAll();
    }

    @Override
    public Optional<Icon> getIconById(Long id) {
        return Optional.empty();
    }

    @Override
    public Icon saveIcon(Icon u) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
