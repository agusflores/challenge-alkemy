package com.demo.challengealkemy.service.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.demo.challengealkemy.dto.icon.CreateOrUpdateIconDTO;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.model.Icon;
import com.demo.challengealkemy.model.IconContinent;

public interface IconService {
    List<Icon> getAllIcons();

    List<IconContinent> getAllIconsWithDetails();

    List<Icon> getByDenomination(String denomination);
    List<Icon> getByCreationDate(String creationDate) throws ParseException;
    List<Icon> getBtCityId(Long id);

    Optional<Icon> getIconById(Long id);
    ResponseBase createIcon(CreateOrUpdateIconDTO iconDTO);
    ResponseBase updateIcon(Long iconId, CreateOrUpdateIconDTO iconDTO);

    boolean deleteById(Long id);
}
