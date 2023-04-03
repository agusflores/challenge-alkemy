package com.demo.challengealkemy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String denomination;
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private List<City> citiesList = new ArrayList<City>();

    public Continent() {
    }

    public Continent(Long id, String image, String denomination, List<City> citiesList) {
        this.id = id;
        this.image = image;
        this.denomination = denomination;
        this.citiesList = citiesList;
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

    public List<City> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(List<City> citiesList) {
        this.citiesList = citiesList;
    }
}
