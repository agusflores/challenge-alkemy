package com.demo.challengealkemy.service.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.demo.challengealkemy.model.Icon;

public interface IconService {
    List<Icon> getAllIcons();
    Optional<Icon> getIconById(Long id);
    Icon saveIcon(Icon u);
    boolean deleteById(Long id);
}
