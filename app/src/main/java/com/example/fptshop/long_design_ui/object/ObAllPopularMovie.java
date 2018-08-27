package com.example.fptshop.long_design_ui.object;

public class ObAllPopularMovie {
    private int imgAllPopularMovie;
    private String tvAllPopularMovie;

    public ObAllPopularMovie(){}

    public ObAllPopularMovie(int imgAllPopularMovie, String tvAllPopularMovie) {
        this.imgAllPopularMovie = imgAllPopularMovie;
        this.tvAllPopularMovie = tvAllPopularMovie;
    }

    public int getImgAllPopularMovie() {
        return imgAllPopularMovie;
    }

    public void setImgAllPopularMovie(int imgAllPopularMovie) {
        this.imgAllPopularMovie = imgAllPopularMovie;
    }

    public String getTvAllPopularMovie() {
        return tvAllPopularMovie;
    }

    public void setTvAllPopularMovie(String tvAllPopularMovie) {
        this.tvAllPopularMovie = tvAllPopularMovie;
    }
}
