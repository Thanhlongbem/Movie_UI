package com.example.fptshop.long_design_ui.Object;

public class ObMovieHotMovie {
    private int imgHotMovie;
    private String tvHotMovie;

    public ObMovieHotMovie(){}


    public ObMovieHotMovie(int imgHotMovie, String tvHotMovie) {
        this.imgHotMovie = imgHotMovie;
        this.tvHotMovie = tvHotMovie;
    }

    public int getImgHotMovie() {
        return imgHotMovie;
    }

    public void setImgHotMovie(int imgHotMovie) {
        this.imgHotMovie = imgHotMovie;
    }

    public String getTvHotMovie() {
        return tvHotMovie;
    }

    public void setTvHotMovie(String tvHotMovie) {
        this.tvHotMovie = tvHotMovie;
    }
}
