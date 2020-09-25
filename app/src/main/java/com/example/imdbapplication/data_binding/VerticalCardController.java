package com.example.imdbapplication.data_binding;

public class VerticalCardController {
    private String id;
    private String title;
    private String imgUrl;
    private String midTxt1;
    private String midTxt2;
    private String midTxt3;
    private String midTxt4;
    private String bottomTxt;

    public VerticalCardController(String id, String title, String imgUrl, String midTxt1, String midTxt2, String midTxt3, String midTxt4, String bottomTxt) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.midTxt1 = midTxt1;
        this.midTxt2 = midTxt2;
        this.midTxt3 = midTxt3;
        this.midTxt4 = midTxt4;
        this.bottomTxt = bottomTxt;
    }

    public VerticalCardController() {
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

    public String getMidTxt1() {
        return midTxt1;
    }

    public void setMidTxt1(String midTxt1) {
        this.midTxt1 = midTxt1;
    }

    public String getMidTxt2() {
        return midTxt2;
    }

    public void setMidTxt2(String midTxt2) {
        this.midTxt2 = midTxt2;
    }

    public String getMidTxt3() {
        return midTxt3;
    }

    public void setMidTxt3(String midTxt3) {
        this.midTxt3 = midTxt3;
    }

    public String getMidTxt4() {
        return midTxt4;
    }

    public void setMidTxt4(String midTxt4) {
        this.midTxt4 = midTxt4;
    }

    public String getBottomTxt() {
        return bottomTxt;
    }

    public void setBottomTxt(String bottomTxt) {
        this.bottomTxt = bottomTxt;
    }
}
