package com.demo.challengealkemy.dto.icon;

public class IconDTO {

    private String image;
    private String denomination;

    public IconDTO() {
    }

    public IconDTO(String image, String denomination) {
        this.image = image;
        this.denomination = denomination;
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
}
