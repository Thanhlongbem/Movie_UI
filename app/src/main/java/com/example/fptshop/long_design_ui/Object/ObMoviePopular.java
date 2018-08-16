package com.example.fptshop.long_design_ui.Object;

public class ObMoviePopular {
    private int imgPopular1;
    private String nameMoviePopular1;
    private int imgPopular2;
    private String nameMoviePopular2;

    public ObMoviePopular(int imgPopular1, String nameMoviePopular1, int imgPopular2, String nameMoviePopular2) {
        this.imgPopular1 = imgPopular1;
        this.nameMoviePopular1 = nameMoviePopular1;
        this.imgPopular2 = imgPopular2;
        this.nameMoviePopular2 = nameMoviePopular2;
    }

    public ObMoviePopular(ObMovie obMovie, ObMovie obMovie1) {
    }

    public int getImgPopular1() {
        return imgPopular1;
    }

    public void setImgPopular1(int imgPopular1) {
        this.imgPopular1 = imgPopular1;
    }

    public String getNameMoviePopular1() {
        return nameMoviePopular1;
    }

    public void setNameMoviePopular1(String nameMoviePopular1) {
        this.nameMoviePopular1 = nameMoviePopular1;
    }

    public int getImgPopular2() {
        return imgPopular2;
    }

    public void setImgPopular2(int imgPopular2) {
        this.imgPopular2 = imgPopular2;
    }

    public String getNameMoviePopular2() {
        return nameMoviePopular2;
    }

    public void setNameMoviePopular2(String nameMoviePopular2) {
        this.nameMoviePopular2 = nameMoviePopular2;
    }
}
