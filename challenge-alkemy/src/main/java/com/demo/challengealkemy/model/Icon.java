package com.demo.challengealkemy.model;

import com.demo.challengealkemy.dto.icon.CreateIconDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Icon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String denomination;
    private Date creation;
    private float height;

    private String history;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Icon() {
    }

    public Icon(Long id, String image, String denomination, Date creation, float height, String history, City city) {
        this.id = id;
        this.image = image;
        this.denomination = denomination;
        this.creation = creation;
        this.height = height;
        this.history = history;
        this.city = city;
    }

    public Icon(CreateIconDTO dto, City city) {
        this.image = dto.getImage();
        this.denomination = dto.getDenomination();
        this.creation = dto.getCreation();
        this.height = dto.getHeight();
        this.history = dto.getHistory();
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
