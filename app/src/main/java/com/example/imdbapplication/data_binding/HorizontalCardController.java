package com.example.imdbapplication.data_binding;

public class HorizontalCardController {
    private String id;
    private String title;
    private String imgUrl;
    private String description;

    public HorizontalCardController(String id, String title, String imgUrl, String description) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.description = description;
    }

    public HorizontalCardController() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
