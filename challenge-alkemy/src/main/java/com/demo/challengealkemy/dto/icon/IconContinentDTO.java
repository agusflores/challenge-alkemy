package com.demo.challengealkemy.dto.icon;

import com.demo.challengealkemy.model.IconContinent;

import java.util.Date;

public class IconContinentDTO {
    private String iconImage;
    private String iconDenomination;
    private Date iconCreation;
    private float iconHeight;
    private String iconHistory;
    private String iconContinent;

    public IconContinentDTO() {
    }

    public IconContinentDTO(String iconImage, String iconDenomination, Date iconCreation, float iconHeight, String iconHistory, String iconContinent) {
        this.iconImage = iconImage;
        this.iconDenomination = iconDenomination;
        this.iconCreation = iconCreation;
        this.iconHeight = iconHeight;
        this.iconHistory = iconHistory;
        this.iconContinent = iconContinent;
    }

    public IconContinentDTO(IconContinent iconContinent) {
        this.iconImage = iconContinent.getImage();
        this.iconDenomination = iconContinent.getDenomination();
        this.iconCreation = iconContinent.getCreation();
        this.iconHeight = iconContinent.getHeight();
        this.iconHistory = iconContinent.getHistory();
        this.iconContinent = iconContinent.getIconContinent();
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public String getIconDenomination() {
        return iconDenomination;
    }

    public void setIconDenomination(String iconDenomination) {
        this.iconDenomination = iconDenomination;
    }

    public Date getIconCreation() {
        return iconCreation;
    }

    public void setIconCreation(Date iconCreation) {
        this.iconCreation = iconCreation;
    }

    public float getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(float iconHeight) {
        this.iconHeight = iconHeight;
    }

    public String getIconHistory() {
        return iconHistory;
    }

    public void setIconHistory(String iconHistory) {
        this.iconHistory = iconHistory;
    }

    public String getIconContinent() {
        return iconContinent;
    }

    public void setIconContinent(String iconContinent) {
        this.iconContinent = iconContinent;
    }
}
