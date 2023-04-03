package com.demo.challengealkemy.dto.user;


public class RegisterUserDTO {

    private String address;
    private String email;
    private String name;
    private String password;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String address, String email, String name, String password) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.password = password;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
