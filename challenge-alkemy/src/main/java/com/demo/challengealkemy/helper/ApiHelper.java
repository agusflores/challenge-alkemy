package com.demo.challengealkemy.helper;

import com.demo.challengealkemy.dto.user.LoginUserDTO;
import com.demo.challengealkemy.dto.user.RegisterUserDTO;
import com.demo.challengealkemy.model.User;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class ApiHelper {

    public static ResponseEntity<ResponseBase> badRequestRegisterResponse() {
        ResponseBase response = new ResponseBase("Faltan datos para poder registrar un nuevo usuario", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> badRequestLoginResponse() {
        ResponseBase response = new ResponseBase("Falta ingresar nombre y/o contraseña para poder ingresar", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }
    public static ResponseEntity<ResponseBase> emailExistsResponse() {
        ResponseBase response = new ResponseBase("Ya existe un usuario con el mail ingresado", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> notRegisteredUser() {
        ResponseBase response = new ResponseBase("Ocurrio un error al intentar registrar el usuario. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }
    public static ResponseEntity<ResponseBase> registeredUser() {
        ResponseBase response = new ResponseBase("El usuario se ha registrado correctamente", "OK");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ResponseBase> loggedUser() {
        ResponseBase response = new ResponseBase("El usuario se ha loggeado correctamente", "OK");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ResponseBase> notLoggedUser() {
        ResponseBase response = new ResponseBase("Los datos ingresados son incorrectos. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }
    public static boolean validateRegisterRequest(RegisterUserDTO userDTO) {
        return (userDTO.getName() == null || userDTO.getAddress() == null || userDTO.getEmail() == null || userDTO.getPassword() == null);
    }

    public static boolean validateLoginRequest(LoginUserDTO userDTO) {
        return (userDTO.getEmail() == null || userDTO.getPassword() == null);
    }

    public static User registerUserDtoToEntity(RegisterUserDTO dto) throws Exception {
        dto.setPassword(CryptoUtils.encrypt(dto.getPassword()));
        return new User(dto);
    }
}
