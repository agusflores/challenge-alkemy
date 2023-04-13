package com.demo.challengealkemy.controller;


import com.demo.challengealkemy.dto.icon.IconDTO;
import com.demo.challengealkemy.helper.ApiHelper;
import com.demo.challengealkemy.service.interfaces.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconController {

    @Autowired
    private IconService service;

    @GetMapping("/get-all-icons")
    public ResponseEntity<List<IconDTO>> getIcons() {
        List<IconDTO> icons = ApiHelper.IconEntityToIconDTO(service.getAllIcons());
        return ResponseEntity.ok(icons);
    }

}
