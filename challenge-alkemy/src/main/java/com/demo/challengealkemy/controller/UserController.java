package com.demo.challengealkemy.controller;

import com.demo.challengealkemy.dto.user.LoginUserDTO;
import com.demo.challengealkemy.dto.user.RegisterUserDTO;
import com.demo.challengealkemy.helper.ApiHelper;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.model.User;
import com.demo.challengealkemy.service.interfaces.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    public String token;
    @Autowired
    private UserService service;

    @PermitAll
    @PostMapping("/register")
    public ResponseEntity<ResponseBase> createUser(@RequestBody RegisterUserDTO userDTO) throws Exception {
        if (ApiHelper.validateRegisterRequest(userDTO)) {
            return ApiHelper.badRequestRegisterResponse();
        }
        if (service.emailExists(userDTO.getEmail())) {
            return ApiHelper.emailExistsResponse();
        }
        User u = service.saveUser(ApiHelper.registerUserDtoToEntity(userDTO));
        if (u == null) {
            return ApiHelper.notRegisteredUser();
        }
        return ApiHelper.registeredUser();
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBase> logUser(@RequestBody LoginUserDTO userDTO) throws Exception {
        if (ApiHelper.validateLoginRequest(userDTO)) {
            return ApiHelper.badRequestLoginResponse();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.getPassword());
        Optional<User> u = service.getUserByEmailAndPassword(userDTO.getEmail(), encryptedPassword);
        if (!u.isPresent()) {
            return ApiHelper.notLoggedUser();
        }
        return ApiHelper.loggedUser();
     }

     @GetMapping("saludar")
    public String saludar() {
        return "Hola mundo";
     }
}
