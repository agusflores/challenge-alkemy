package com.demo.challengealkemy.controller;

import com.demo.challengealkemy.dto.user.LoginUserDTO;
import com.demo.challengealkemy.dto.user.RegisterUserDTO;
import com.demo.challengealkemy.helper.ApiHelper;
import com.demo.challengealkemy.helper.CryptoUtils;
import com.demo.challengealkemy.helper.JwtUtils;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.model.User;
import com.demo.challengealkemy.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("user/")
public class UserController {

    public String token;

    @Autowired
    private UserService service;

    @PostMapping("register")
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
        this.token = JwtUtils.generateToken(u.getEmail());
        return ApiHelper.registeredUser();
    }

    @PostMapping("login")
    public ResponseEntity<ResponseBase> logUser(@RequestBody LoginUserDTO userDTO) throws Exception {
        if (ApiHelper.validateLoginRequest(userDTO)) {
            return ApiHelper.badRequestLoginResponse();
        }
        String encryptedPassword = CryptoUtils.encrypt(userDTO.getPassword());
        Optional<User> u = service.getUserByEmailAndPassword(userDTO.getEmail(), encryptedPassword);
        if (!u.isPresent()) {
            return ApiHelper.notLoggedUser();
        }
        this.token = JwtUtils.generateToken(u.get().getEmail());
        return ApiHelper.loggedUser();
     }

     @GetMapping("saludar")
    public String saludar() {
        if (this.token != null && JwtUtils.validateToken(this.token)) {
            return "Hola mundo";
        }
        return "No tiene validacion";
     }
}
