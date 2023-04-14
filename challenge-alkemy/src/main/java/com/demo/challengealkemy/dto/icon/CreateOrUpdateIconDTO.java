package com.demo.challengealkemy.dto.icon;

import java.util.Date;

public class CreateOrUpdateIconDTO {

    private String image;
    private String denomination;
    private Date creation;
    private float height;
    private String history;
    private Long cityId;

    public CreateOrUpdateIconDTO() {

    }

    public CreateOrUpdateIconDTO(String image, String denomination, Date creation, float height, String history, Long cityId) {
        this.image = image;
        this.denomination = denomination;
        this.creation = creation;
        this.height = height;
        this.history = history;
        this.cityId = cityId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
