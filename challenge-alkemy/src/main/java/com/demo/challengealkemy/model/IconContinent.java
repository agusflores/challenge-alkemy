package com.demo.challengealkemy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "icon_details")
public class IconContinent {
    @Column(name = "ICON_IMAGE")
    private String image;
    @Id
    @Column(name = "ICON_DENOMINATION")
    private String denomination;
    @Column(name = "ICON_CREATION")
    private Date creation;
    @Column(name = "ICON_HEIGHT")
    private float height;
    @Column(name = "ICON_HISTORY")
    private String history;
    @Column(name = "ICON_CONTINENT")
    private String iconContinent;

    public IconContinent() {
    }

    public IconContinent(String image, String denomination, Date creation, float height, String history, String iconContinent) {
        this.image = image;
        this.denomination = denomination;
        this.creation = creation;
        this.height = height;
        this.history = history;
        this.iconContinent = iconContinent;
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

    public String getIconContinent() {
        return iconContinent;
    }

    public void setIconContinent(String iconContinent) {
        this.iconContinent = iconContinent;
    }
}
