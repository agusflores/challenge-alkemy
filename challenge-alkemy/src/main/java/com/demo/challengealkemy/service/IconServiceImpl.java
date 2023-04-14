package com.demo.challengealkemy.service;

import com.demo.challengealkemy.dto.icon.CreateIconDTO;
import com.demo.challengealkemy.helper.ApiHelper;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.model.City;
import com.demo.challengealkemy.model.Icon;
import com.demo.challengealkemy.repository.CityRepository;
import com.demo.challengealkemy.repository.IconRepository;
import com.demo.challengealkemy.service.interfaces.IconService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconRepository repository;
    @Autowired
    private CityRepository cityRepository;


    @Override
    public List<Icon> getAllIcons() {
        return (List<Icon>) repository.findAll();
    }

    @Override
    public Optional<Icon> getIconById(Long id) {
        return Optional.empty();
    }

    @Override
    public ResponseBase createIcon(CreateIconDTO iconDTO) {
        if (ApiHelper.validateCreateIconRequest(iconDTO)) {
            return ApiHelper.invalidCreateIconRequest().getBody();
        }
        Optional<City> c = cityRepository.findById(iconDTO.getCityId());

        if (!c.isPresent()) {
            return ApiHelper.invalidCityId().getBody();
        }
        repository.save(ApiHelper.createIconDTOToEntity(iconDTO, c.get()));
        return ApiHelper.iconCreated().getBody();
    }

    @Override
    public ResponseBase updateIcon(Long iconId, CreateIconDTO iconDTO) {
        Optional<City> c = cityRepository.findById(iconDTO.getCityId());
        if (!c.isPresent()) {
            return ApiHelper.invalidCityId().getBody();
        }

        Optional<Icon> i = repository.findById(iconId);

        if (!i.isPresent()) {
            return ApiHelper.invalidIconId().getBody();
        }
        Icon iconExists = i.get();
        iconExists.setImage(iconDTO.getImage());
        iconExists.setDenomination(iconDTO.getDenomination());
        iconExists.setCreation(iconDTO.getCreation());
        iconExists.setHeight(iconDTO.getHeight());
        iconExists.setHistory(iconDTO.getHistory());
        iconExists.setCity(c.get());
        repository.save(iconExists);
        return ApiHelper.iconUpdated().getBody();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
