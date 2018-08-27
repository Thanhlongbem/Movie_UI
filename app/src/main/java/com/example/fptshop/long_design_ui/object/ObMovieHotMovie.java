package com.example.fptshop.long_design_ui.object;

public class ObMovieHotMovie {
    private String thumbnailUrl;
    private String title;
    private String subTitle;

    public ObMovieHotMovie(String thumbnailUrl, String title, String subTitle) {
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
