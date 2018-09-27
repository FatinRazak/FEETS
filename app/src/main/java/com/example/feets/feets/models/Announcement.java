package com.example.feets.feets.models;

public class Announcement {

    private String item;
    private String subitem;
    private Integer imgid;

    public Announcement(String item, String subitem, Integer imgid) {
        this.item = item;
        this.subitem = subitem;
        this.imgid = imgid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSubitem() {
        return subitem;
    }

    public void setSubitem(String subitem) {
        this.subitem = subitem;
    }

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }
}
