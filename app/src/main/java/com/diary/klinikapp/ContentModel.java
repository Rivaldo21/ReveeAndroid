package com.diary.klinikapp;

public class ContentModel {

    String judul, tahun;
    int img;

    public ContentModel(String judul, String tahun, int img) {
        this.judul = judul;
        this.tahun = tahun;
        this.img = img;
    }

    public String getJudul() {
        return judul;
    }

    public String getTahun() {
        return tahun;
    }

    public int getImg() {
        return img;
    }
}
