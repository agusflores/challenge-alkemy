package com.demo.challengealkemy.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.demo.challengealkemy.dto.icon.CreateOrUpdateIconDTO;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.model.Icon;

public interface IconService {
    List<Icon> getAllIcons();
    Optional<Icon> getIconById(Long id);
    ResponseBase createIcon(CreateOrUpdateIconDTO iconDTO);
    ResponseBase updateIcon(Long iconId, CreateOrUpdateIconDTO iconDTO);

    boolean deleteById(Long id);
}
