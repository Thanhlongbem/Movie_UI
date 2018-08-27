package com.example.fptshop.long_design_ui.object;

import java.util.List;

public class ObTrailer {
    private int errorCode;
    private String message;
    private List<ObMovieNewFeed> data;


    public ObTrailer(int errorCode, String message, List<ObMovieNewFeed> data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ObMovieNewFeed> getData() {
        return data;
    }

    public void setData(List<ObMovieNewFeed> data) {
        this.data = data;
    }
}
