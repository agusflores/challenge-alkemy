package com.demo.challengealkemy.service.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.challengealkemy.dto.icon.CreateIconDTO;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.model.Icon;

public interface IconService {
    List<Icon> getAllIcons();
    Optional<Icon> getIconById(Long id);
    ResponseBase createIcon(CreateIconDTO iconDTO);
    ResponseBase updateIcon(Long iconId, CreateIconDTO iconDTO);

    boolean deleteById(Long id);
}
