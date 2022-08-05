package com.diary.klinikapp;

public class Pojo {

    private String name;
    private String subtitle;
    private int image;

    public Pojo(String name, String subtitle, int image) {
        this.name = name;
        this.image = image;
        this.subtitle = subtitle;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getSubtitle() {return subtitle;}
}
