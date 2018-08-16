package com.example.fptshop.long_design_ui.Object;

public class ObMovie {
    private int movie;
    private String tvNameMovie;


    public ObMovie(){}

    public ObMovie(int movie, String tvNameMovie) {
        this.movie = movie;
        this.tvNameMovie = tvNameMovie;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public String getTvNameMovie() {
        return tvNameMovie;
    }

    public void setTvNameMovie(String tvNameMovie) {
        this.tvNameMovie = tvNameMovie;
    }
}
