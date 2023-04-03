package com.demo.challengealkemy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String denomination;
    private String surface;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Icon> iconsList = new ArrayList<Icon>();
    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    public City() {
    }

    public City(Long id, String image, String denomination, String surface, List<Icon> iconsList, Continent continent) {
        this.id = id;
        this.image = image;
        this.denomination = denomination;
        this.surface = surface;
        this.iconsList = iconsList;
        this.continent = continent;
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

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public List<Icon> getIconsList() {
        return iconsList;
    }

    public void setIconsList(List<Icon> iconsList) {
        this.iconsList = iconsList;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
