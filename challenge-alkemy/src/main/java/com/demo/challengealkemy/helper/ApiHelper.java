package com.demo.challengealkemy.helper;

import com.demo.challengealkemy.dto.icon.CreateOrUpdateIconDTO;
import com.demo.challengealkemy.dto.icon.IconContinentDTO;
import com.demo.challengealkemy.dto.icon.IconDTO;
import com.demo.challengealkemy.dto.user.LoginUserDTO;
import com.demo.challengealkemy.dto.user.RegisterUserDTO;
import com.demo.challengealkemy.model.City;
import com.demo.challengealkemy.model.Icon;
import com.demo.challengealkemy.model.IconContinent;
import com.demo.challengealkemy.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class ApiHelper {

    //--------------------------------- ARMAR RESPONSES ---------------------------------

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

    public static ResponseEntity<ResponseBase> iconCreated() {
        ResponseBase response = new ResponseBase("El icono se ha creado correctamente", "OK");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ResponseBase> iconUpdated() {
        ResponseBase response = new ResponseBase("El icono se ha actualizado correctamente", "OK");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ResponseBase> iconDeleted() {
        ResponseBase response = new ResponseBase("El icono se ha eliminado correctamente", "OK");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ResponseBase> notLoggedUser() {
        ResponseBase response = new ResponseBase("Los datos ingresados son incorrectos. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> invalidCreateIconRequest() {
        ResponseBase response = new ResponseBase("Faltan datos para poder crear un nuevo Icono Geografico. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> invalidUpdateIconRequest() {
        ResponseBase response = new ResponseBase("Debe ingresar todos los datos del Icono para poder actualizarlo. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> invalidDeleteIconRequest() {
        ResponseBase response = new ResponseBase("El Icono no se ha podido eliminar. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> invalidCityId() {
        ResponseBase response = new ResponseBase("La ciudad ingresada es incorrecta. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseBase> invalidIconId() {
        ResponseBase response = new ResponseBase("El Icono Geografico ingresado es incorrecto. Por favor, volver a intentarlo", "ERROR");
        return new ResponseEntity<ResponseBase>(response, HttpStatus.BAD_REQUEST);
    }

    //--------------------------------- VALIDAR REQUESTS ---------------------------------

    public static boolean validateRegisterRequest(RegisterUserDTO userDTO) {
        return (userDTO.getName() == null || userDTO.getAddress() == null || userDTO.getEmail() == null || userDTO.getPassword() == null);
    }

    public static boolean validateLoginRequest(LoginUserDTO userDTO) {
        return (userDTO.getEmail() == null || userDTO.getPassword() == null);
    }

    public static boolean validateCreateIconRequest(CreateOrUpdateIconDTO iconDTO) {
        return (iconDTO.getImage() == null
                || iconDTO.getDenomination() == null
                || iconDTO.getCreation() == null
                || Float.isNaN(iconDTO.getHeight())
                || iconDTO.getHistory() == null
                || iconDTO.getCityId() == null);
    }

    //--------------------------------- MAPPERS ---------------------------------

    public static List<IconDTO> IconEntityToIconDTO(List<Icon> list) {
        List<IconDTO> listIconsDTO = new ArrayList<>();
        list.stream().forEach(i -> {
            listIconsDTO.add(new IconDTO(i.getImage(), i.getDenomination()));
        });
        return listIconsDTO;
    }

    public static List<IconContinentDTO> IconContinentToIconContinentDTO(List<IconContinent> list) {
        List<IconContinentDTO> listIconsDTO = new ArrayList<>();
        list.stream().forEach(i -> {
            listIconsDTO.add(new IconContinentDTO(i));
        });
        return listIconsDTO;
    }


    public static Icon createIconDTOToEntity(CreateOrUpdateIconDTO dto, City city) {
        return new Icon(dto, city);
    }

    public static Icon updateIconDTOToEntity(Icon iconToSave, CreateOrUpdateIconDTO iconToUpdate, City c) {
        iconToSave.setImage(iconToUpdate.getImage());
        iconToSave.setDenomination(iconToUpdate.getDenomination());
        iconToSave.setCreation(iconToUpdate.getCreation());
        iconToSave.setHeight(iconToUpdate.getHeight());
        iconToSave.setHistory(iconToUpdate.getHistory());
        iconToSave.setCity(c);
        return iconToSave;
    }

    public static User registerUserDtoToEntity(RegisterUserDTO dto)  {
        dto.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        return new User(dto);
    }
}
